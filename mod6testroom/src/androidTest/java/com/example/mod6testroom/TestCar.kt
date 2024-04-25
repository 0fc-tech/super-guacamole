package com.example.mod6testroom

import android.content.Context
import androidx.room.Query
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mod6testroom.bo.Car
import com.example.mod6testroom.dao.CarDao
import com.example.mod6testroom.db.CarDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParcAutomobileDbTest {
    private lateinit var database: CarDatabase
    private lateinit var dao: CarDao
    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context,CarDatabase::class.java)
            .build()
        dao = database.carDao()
    }
    @After
    fun tearDown() {
        database.close()
    }
    @Test
    fun writeAndReadYourEntity() = runBlocking {
        val megane = Car(0L,"Renault","Megane E-Tech","GG-123-AZ",
            35000,"EL")
        val twingo = Car(0L,"Renault","Twingo E-Tech","GA-421-SA",
            25000,"EL")
        //Insérez et verifiez que la base de données possède bien
        //vos 2 voitures
        dao.insert(megane).also {id->
            assert(dao.getById(id) == megane)
        }
        dao.insert(twingo).also {id->
            assert(dao.getById(id) == twingo)
        }
        assert(dao.getAll().size == 2)

    }
}