package com.interviewprep.seniorandroiddev.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.interviewprep.seniorandroiddev.model.Breed

@Database(entities = [(Breed::class)], version = 1)
abstract class BreedDatabase: RoomDatabase() {
    abstract fun breedDao(): BreedDAO
}