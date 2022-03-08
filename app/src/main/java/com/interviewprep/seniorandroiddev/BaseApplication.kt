package com.interviewprep.seniorandroiddev

import android.app.Application
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import com.interviewprep.seniorandroiddev.model.Breed
import com.interviewprep.seniorandroiddev.model.BreedAttributes
import com.interviewprep.seniorandroiddev.model.room.BreedDatabase
import kotlinx.coroutines.*

class BaseApplication: Application() {
    companion object {
        lateinit var database: BreedDatabase
        var applicationScope = MainScope()
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, BreedDatabase::class.java, "breed_database").build()
        Companion.applicationScope.launch {
            database.breedDao().insert(Breed(BreedAttributes()))
            database.breedDao().insert(Breed(BreedAttributes(purpose = "FAMILY"), "Labarador"))
        }

    }
}