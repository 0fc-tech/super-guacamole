package com.example.enishopit.data

import android.content.Context
import androidx.room.Room

class DbClient(appContext: Context) {
    val db: DbEniShop = Room.databaseBuilder(
        appContext,
        DbEniShop::class.java, "eni_shop.db"
    ).build()
}