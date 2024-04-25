package com.example.mod6testroom.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mod6testroom.bo.Car
import com.example.mod6testroom.dao.CarDao

@Database(entities = arrayOf(Car::class), version = 1)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}