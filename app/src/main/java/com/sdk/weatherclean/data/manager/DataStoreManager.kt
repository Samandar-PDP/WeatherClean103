package com.sdk.weatherclean.data.manager

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager(private val context: Context) {
    private val Context.dataStore by preferencesDataStore(name = "DataStore")

    companion object {
        val THEME = intPreferencesKey(name = "index")
    }

    suspend fun saveTheme(index: Int) {
        context.dataStore.edit {
            it[THEME] = index
        }
    }

    fun getTheme(): Flow<Int> = context.dataStore.data.map {
        it[THEME] ?: 0
    }
}