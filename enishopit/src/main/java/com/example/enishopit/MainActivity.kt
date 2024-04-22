package com.example.enishopit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.enishopit.ui.screen.DetailProductScren
import com.example.enishopit.ui.screen.ListProductsScreen
import com.example.enishopit.ui.theme.TPTheme

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
                    NavigationHost()
                }
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        startDestination = "list",
        navController = navController
    ){
        composable("list"){
            ListProductsScreen(onProductClick = {id->
                navController.navigate("detail/$id")
            })
        }
        composable("detail/{productId}",
            arguments = listOf(navArgument("productId"){
                type= NavType.LongType
            })){entry->
            DetailProductScren(entry.arguments!!.getLong("productId"))
        }
    }

}























