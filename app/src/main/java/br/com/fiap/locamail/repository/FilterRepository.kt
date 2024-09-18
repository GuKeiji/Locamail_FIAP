package br.com.fiap.locamail.repository

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FilterRepository private constructor(private val context: Context) {
    private val Context.dataStore by preferencesDataStore("filters")

    companion object {
        @Volatile   
        private var INSTANCE: FilterRepository? = null

        fun getInstance(context: Context): FilterRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: FilterRepository(context.applicationContext).also { INSTANCE = it }
            }
        }

        val FILTERS_KEY = stringSetPreferencesKey("filters_key")
    }

    val filters: Flow<Set<String>> = context.dataStore.data
        .map { preferences ->
            preferences[FILTERS_KEY] ?: emptySet()
        }

    suspend fun addFilter(filter: String) {
        context.dataStore.edit { preferences ->
            val currentFilters = preferences[FILTERS_KEY] ?: emptySet()
            preferences[FILTERS_KEY] = currentFilters + filter
        }
    }
}
