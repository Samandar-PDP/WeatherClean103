package com.sdk.weatherclean.di

import android.content.Context
import androidx.room.Room
import com.sdk.weatherclean.data.database.WeatherDao
import com.sdk.weatherclean.data.database.WeatherDatabase
import com.sdk.weatherclean.data.repository.LocalRepositoryImpl
import com.sdk.weatherclean.domain.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(
        @ApplicationContext context: Context
    ): WeatherDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java,
            "Weather.db"
        ).fallbackToDestructiveMigration().build()
    }

    @[Provides Singleton]
    fun provideWeatherDao(
        weatherDatabase: WeatherDatabase
    ): WeatherDao {
        return weatherDatabase.dao
    }

    @[Provides Singleton]
    fun provideLocalRepository(
        dao: WeatherDao
    ): LocalRepository {
        return LocalRepositoryImpl(dao)
    }
}