package com.example.enishopit.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.enishopit.bo.Product
import com.example.enishopit.data.DbClient
import com.example.enishopit.data.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class ProductRepository(val dao: ProductDao) {

    fun getById(id: Long) = dao.getById(id)
    fun getAll() =dao.getAll()
    fun insertProduct(product : Product) = dao.insert(product)
}
