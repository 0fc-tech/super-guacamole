package com.example.enishopit.bo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title:String,
    @ColumnInfo("url_image")
    val urlImage: String,
    val price: Float,
    val category :String)