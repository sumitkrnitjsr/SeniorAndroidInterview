package com.interviewprep.seniorandroiddev.mvp

import android.app.Application
import androidx.room.Room
import com.interviewprep.seniorandroiddev.mvp.model.Breed
import com.interviewprep.seniorandroiddev.mvp.model.BreedAttributes
import com.interviewprep.seniorandroiddev.mvp.model.room.BreedDatabase
import kotlinx.coroutines.*

class BaseApplication: Application() {
    companion object {
        lateinit var database: BreedDatabase
        var applicationScope = MainScope()
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, BreedDatabase::class.java, "breed_database").build()
        applicationScope.launch {
            database.breedDao().insert(Breed(BreedAttributes()))
            database.breedDao().insert(Breed(BreedAttributes(purpose = "FAMILY"), "Labarador"))
        }

    }

}