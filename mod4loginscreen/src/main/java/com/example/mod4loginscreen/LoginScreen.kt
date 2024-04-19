package com.example.mod4loginscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(vm : LoginViewModel = viewModel()) {
    var email by rememberSaveable { mutableStateOf("")}
    var password by rememberSaveable { mutableStateOf("")}
    val loginState = vm.loginState
    LazyColumn(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{
        //Spacer(Modifier.weight(1F))
        TextField(
            value =email,
            onValueChange = {email = it},
            Modifier.padding(8.dp),
            label = {Text("Email")}
        )
        TextField(
            value = password,
            onValueChange = {password = it},
            Modifier.padding(8.dp),
            label = {Text("Password")}
        )
        //Spacer(Modifier.weight(1F))
        Button(
            onClick = {vm.connexion(email, password)},
            enabled = loginState !is LoginState.LoginLoading,
        ){
            if(loginState is LoginState.LoginLoading)
                    CircularProgressIndicator()
            else
                Text("Connexion")
        }
        Button(onClick = {}){
            Text("Inscription")
        }
        TextButton(onClick = {}){
            Text("Mot de passe oublié")
        }
        if(loginState is LoginState.LoggedInSuccess){
            Text("Bravo vous êtes connecté avec le token " +
                    loginState.token
            )
        }else if (loginState is LoginState.LoginError){
            Text("Désolé ça ne fonctionne pas :  " +
                    loginState.msg
            )
        }

        //Spacer(Modifier.weight(1F))
        }
    }
}