package com.example.enishopit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.enishopit.bo.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert
    fun insert(product : Product):Long
    @Insert
    fun insertAll(product : List<Product>):List<Long>

    @Query("SELECT * FROM Product")
    fun getAll() : Flow<List<Product>>

    @Query("SELECT * FROM Product WHERE id=:id")
    fun getById(id: Long) : Flow<Product>
}








