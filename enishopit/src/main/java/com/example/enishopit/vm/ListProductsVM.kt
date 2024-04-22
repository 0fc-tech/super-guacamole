package com.example.enishopit.vm

import androidx.lifecycle.ViewModel
import com.example.enishopit.repository.ProductRepository

class ListProductsVM(val repoProducts : ProductRepository =ProductRepository) : ViewModel() {
    fun fetchProducts() = repoProducts.getAll()

}