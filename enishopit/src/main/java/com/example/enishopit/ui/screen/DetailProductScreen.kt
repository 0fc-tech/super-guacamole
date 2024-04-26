package com.example.enishopit.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.enishopit.bo.Product
import com.example.enishopit.vm.DetailProductVM
import com.example.enishopit.ui.theme.Typography
import com.example.enishopit.vm.ListProductsVM

@Composable
fun DetailProductScren(
    idProduct : Long,
    vm : DetailProductVM = viewModel(factory = DetailProductVM.Factory)) {
        val produit by vm.fetchProductById(idProduct).collectAsState(initial = null)
        if(produit == null) Text("Pas de produit")
        else
        Column(Modifier.padding(8.dp)){
            Text(
                produit!!.title,
                style= Typography.headlineSmall)
            Text("${produit!!.price} €" ,style= Typography.labelLarge)
            Text("ou 400€/mois",style= Typography.bodySmall)
            AsyncImage(model = produit!!.urlImage,
                contentDescription="",
                Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.FillHeight)
            Spacer(Modifier.padding(vertical = 8.dp))
            Text("Description",style= Typography.headlineSmall)
            Spacer(Modifier.padding(vertical = 8.dp))
            Text(produit!!.urlImage)
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