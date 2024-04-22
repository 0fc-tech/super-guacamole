package com.example.enishopit

data class Product(
    val id: Long = 0L,
    val title:String,
    val urlImage: String,
    val price: Float,
    val category :String)