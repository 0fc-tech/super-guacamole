package com.example.mod6datastore.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod6datastore.repository.UserPrefRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FormSettingsViewModel(val repo : UserPrefRepo) : ViewModel() {
    val flowAddr1 : Flow<String?> = repo.addr1
    val flowAddr2: Flow<String?> =  repo.addr2
    val flowCodeEntreprise: Flow<String?>  =  repo.codeEntreprise
    val flowCarteReduction: Flow<String?> = repo.carteReduction.map {
        if(it==0L) "" else it.toString()
    }
    fun saveAddress1(addr : String)=viewModelScope.launch { repo.saveAddr1(addr) }

    fun saveAddress2(addr : String)=viewModelScope.launch { repo.saveAddr2(addr) }
    fun saveCodeEntreprise(codeEnt : String)=viewModelScope.launch { repo.saveCodeEntreprise(codeEnt) }
    fun saveCarteReduction(carteRedu : String)=viewModelScope.launch {
        viewModelScope.launch { repo.saveCarteReduction(carteRedu.toLongOrNull() ?: 0) }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return FormSettingsViewModel(
                    UserPrefRepo(application.applicationContext),
                ) as T
            }
        }
    }







}