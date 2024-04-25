package com.example.mod6testroom.bo

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L,
    val brand: String,
    val model : String,
    val licensePlate:String,
    val price:Int,
    val energy:String
){
    override fun equals(other: Any?): Boolean=
        other is Car
            && brand == other.brand
            && model == other.model
            && licensePlate == other.licensePlate
            && price == other.price
            && energy == other.energy

}