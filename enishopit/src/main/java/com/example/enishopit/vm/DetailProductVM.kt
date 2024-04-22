package com.example.enishopit.vm

import androidx.lifecycle.ViewModel
import com.example.enishopit.Product
import com.example.enishopit.repository.ProductRepository

class DetailProductVM(val repoProducts : ProductRepository = ProductRepository) : ViewModel(){
    fun fetchProductById(idProduct: Long): Product?=
        repoProducts.getById(idProduct)
}