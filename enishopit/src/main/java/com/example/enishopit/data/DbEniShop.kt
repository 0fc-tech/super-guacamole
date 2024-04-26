package com.example.enishopit.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.enishopit.bo.Product

@Database(entities = [Product::class],version=1)
abstract class DbEniShop : RoomDatabase() {
    abstract fun productDao() : ProductDao
}









