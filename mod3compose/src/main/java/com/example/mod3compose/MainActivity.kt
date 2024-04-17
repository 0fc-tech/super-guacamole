package com.example.mod3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mod3compose.ui.theme.TPTheme
import com.example.mod3compose.ui.theme.Typography

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
                    DescriptionProduit(Produit(
                        "Ce téléphone vous permettra de passer à un niveau supérieur. Votre productivité sera triplée grâce à son processeur 19 coeurs et à son GPU ultra puissant",
                        2800f
                    ))
                }
            }
        }
    }
}

@Composable
fun DescriptionProduit(produit : Produit) {
    Column(Modifier.padding(8.dp)){
        Text("Apple iPhone Prox Max Edition",
            style= Typography.headlineSmall)
        Text("${produit.prix} €" ,style= Typography.labelLarge)
        Text("ou 400€/mois",style= Typography.bodySmall)
        AsyncImage(model = "https://static.fnac-static.com/multimedia/Images/FR/MDM/18/f1/52/22212888/1540-1/tsp20240308175104/Apple-iPhone-15-Pro-Max-6-7-5G-Double-SIM-256-Go-Natural-Titanium.jpg",
            contentDescription="",
            Modifier.fillMaxWidth().height(350.dp),
            contentScale = ContentScale.FillHeight)
        Spacer(Modifier.padding(vertical = 8.dp))
        Text("Description",style= Typography.headlineSmall)
        Spacer(Modifier.padding(vertical = 8.dp))
        Text(produit.description)
        Spacer(Modifier.padding(vertical = 8.dp))
        Text("Caractéristiques",style= Typography.headlineSmall)
        Spacer(Modifier.padding(vertical = 8.dp))
        Text("Processeur\n" +
                "  19 coeurs\n" +
                "  125 AI Threads\n" +
                "GPU\n" +
                "  256 coeurs\n" +
                "  12 AI\n" +
                "Ecran\n" +
                "  OLED")
    }
}

data class Produit(val description : String, val prix : Float) {

}
