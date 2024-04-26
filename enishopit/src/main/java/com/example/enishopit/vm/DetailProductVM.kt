package com.example.enishopit.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.enishopit.bo.Product
import com.example.enishopit.data.DbClient
import com.example.enishopit.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class DetailProductVM(val repoProducts : ProductRepository) : ViewModel(){
    fun fetchProductById(idProduct: Long): Flow<Product> = repoProducts.getById(idProduct)
    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(
                    extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                )
                return DetailProductVM(ProductRepository(
                    DbClient(application.applicationContext).db.productDao(),
                ))as T
            }
        }
    }
}