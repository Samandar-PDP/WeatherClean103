package com.sdk.weatherclean.di

import com.sdk.weatherclean.data.remote.WeatherService
import com.sdk.weatherclean.data.repository.NetworkRepositoryImpl
import com.sdk.weatherclean.domain.repository.NetworkRepository
import com.sdk.weatherclean.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    @[Provides Singleton]
    fun provideWeatherService(client: OkHttpClient): WeatherService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkRepository(service: WeatherService): NetworkRepository {
        return NetworkRepositoryImpl(service)
    }
}