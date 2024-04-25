package com.example.mod6datastore.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPrefRepo(val context : Context){
    private val Context.dataStore by preferencesDataStore("userpref")
    companion object {
        private val KEY_ADDR_1 = stringPreferencesKey("addr_1")
        private val KEY_ADDR_2 = stringPreferencesKey("addr_2")
        private val KEY_CODE_ENTREPRISE = stringPreferencesKey("code_entreprise")
        private val KEY_CARTE_REDUCTION = longPreferencesKey("carte_reduction")
    }
    val addr1 : Flow<String?> = context.dataStore.data.map { it[KEY_ADDR_1] }
    val addr2 : Flow<String?> = context.dataStore.data.map { it[KEY_ADDR_2] }
    val codeEntreprise : Flow<String?> = context.dataStore.data.map { it[KEY_CODE_ENTREPRISE] }
    val carteReduction : Flow<Long?> = context.dataStore.data.map { it[KEY_CARTE_REDUCTION] }
    suspend fun saveAddr1(addr1 :String) = context.dataStore.edit { it[KEY_ADDR_1] = addr1 }
    suspend fun saveAddr2(addr2 :String) = context.dataStore.edit { it[KEY_ADDR_2] = addr2 }
    suspend fun saveCodeEntreprise(codeEntreprise :String) = context.dataStore.edit { it[KEY_CODE_ENTREPRISE] = codeEntreprise }
    suspend fun saveCarteReduction(carteReduction :Long) = context.dataStore.edit { it[KEY_CARTE_REDUCTION] = carteReduction }


}
