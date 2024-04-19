package com.example.mod4loginscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){
    var loginState by mutableStateOf<LoginState>(LoginState.Init)
        private set
    fun connexion(email :String,mdp : String){
        loginState = LoginState.LoginLoading
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)
            if(email == "aa" && mdp == "aa"){
                loginState = LoginState.LoggedInSuccess("TOKEN")
            }else{
                loginState = LoginState.LoginError("Pas de compte à ce nom")
            }
        }

    }

}


sealed class LoginState{
    data object Init : LoginState()
    data object LoginLoading : LoginState()
    class LoginError(val msg : String) : LoginState()
    class LoggedInSuccess(val token : String) : LoginState()
}