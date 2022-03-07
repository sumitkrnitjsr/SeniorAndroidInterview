package com.interviewprep.seniorandroiddev.model

import kotlinx.coroutines.flow.MutableStateFlow

interface SearchRepository {

    fun addBreed(breed: Breed)
    fun searchBreed(breedAttributes: BreedAttributes): MutableStateFlow<List<Breed>>
    fun deleteBreed(breed: Breed)

}