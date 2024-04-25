package com.example.mod6testroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mod6testroom.bo.Car

@Dao
interface CarDao {
    @Insert
    fun insert(car: Car) : Long
    @Query ("SELECT * FROM Car")
    fun getAll() : List<Car>
    @Query ("SELECT * FROM Car WHERE id = :id")
    fun getById(id:Long) : Car?
}
