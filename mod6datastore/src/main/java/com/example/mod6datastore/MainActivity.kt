package com.example.mod6datastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6datastore.ui.theme.TPTheme
import com.example.mod6datastore.vm.FormSettingsViewModel
import com.example.mod6datastore.vm.FormSettingsViewModel.Companion.Factory
import kotlinx.coroutines.flow.Flow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormSettings()
                }
            }
        }
    }
}

@Composable
fun FormSettings(vm : FormSettingsViewModel = viewModel(factory = Factory)) {
    var adress1UiState by rememberSaveable { mutableStateOf("") }
    var adress2UiState by rememberSaveable { mutableStateOf("") }
    var codeEntrepriseUiState by rememberSaveable { mutableStateOf("") }
    var idCarteReductionUiState by rememberSaveable { mutableStateOf("") }
    val flowAdress1 : String? by vm.flowAddr1.collectAsState(initial = "")
    val flowAdress2 : String? by vm.flowAddr2.collectAsState(initial = "")
    val flowEntreprise : String? by vm.flowCodeEntreprise.collectAsState(initial = "")
    val flowCarteReduction : String? by vm.flowCarteReduction.collectAsState(initial = "")
    adress1UiState = flowAdress1 ?: ""
    adress2UiState = flowAdress2 ?: ""
    codeEntrepriseUiState = flowEntreprise ?: ""
    idCarteReductionUiState = flowCarteReduction ?: ""

    Scaffold(contentWindowInsets = WindowInsets(16.dp, 16.dp, 16.dp, 16.dp)) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card {
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextField(
                        value = adress1UiState,
                        onValueChange = {adress1UiState = it},
                        label = { Text(text = "Adresse 1") },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1F)
                    )
                    IconButton(onClick = { vm.saveAddress1(adress1UiState) }) {
                        Icon(Icons.Default.Check,null)
                    }
                }
            }
            Card {
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextField(
                        value = adress2UiState,
                        onValueChange = {
                            adress2UiState = it
                        },
                        label = { Text(text = "Adresse 2") },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1F)
                    )
                    IconButton(onClick = { vm.saveAddress2(adress2UiState)}) {
                        Icon(Icons.Default.Check,null)
                    }
                }
            }
            Card {
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextField(
                        value = codeEntrepriseUiState,
                        onValueChange = {
                            codeEntrepriseUiState = it
                        },
                        label = { Text(text = "Code Entreprise") },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1F)
                    )
                    IconButton(onClick = {  vm.saveCodeEntreprise(codeEntrepriseUiState)}) {
                        Icon(Icons.Default.Check,null)
                    }
                }
            }
            Card {
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextField(
                        value = idCarteReductionUiState,
                        onValueChange = {
                            if(it.isDigitsOnly()){
                                idCarteReductionUiState = it
                            }
                        },
                        label = { Text(text ="Carte de réduction") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            autoCorrect = true
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1F)
                    )
                    IconButton(onClick = {  vm.saveCarteReduction(idCarteReductionUiState) }) {
                        Icon(Icons.Default.Check,null)
                    }
                }
            }
        }
    }
}








