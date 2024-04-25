package com.example.enishopit.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.enishopit.vm.ListProductsVM
import com.example.enishopit.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListProductsScreen(
    vm : ListProductsVM =viewModel(),
    onProductClick : (idProduct : Long)->Unit)
{
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ENI SHOP") },
                actions = {
                    IconButton(onClick = {}){
                        Icon(Icons.Outlined.ShoppingCart,
                            contentDescription = "shopping cart")
                    }
                }
            )
        }) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(it),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(vm.fetchProducts()) { product ->
                Column {
                    Card(onClick = {
                        onProductClick(product.id)
                    }) {
                        AsyncImage(model = product.urlImage,
                            contentDescription =product.title,
                            modifier=Modifier.padding(28.dp))
                    }
                    Text(product.title)
                    Text("${product.price}€",style=Typography.labelLarge)
                }
            }
        }
    }
}







