package com.interviewprep.seniorandroiddev.model

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breed_table")
data class Breed(
    @Embedded val attributes: BreedAttributes,
    @PrimaryKey @NonNull val name: String =  "Indian Pariah"
)
