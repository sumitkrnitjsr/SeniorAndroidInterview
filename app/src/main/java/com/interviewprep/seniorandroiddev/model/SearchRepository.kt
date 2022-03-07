package com.interviewprep.seniorandroiddev.model

interface SearchRepository {

     fun addBreed(breed: Breed)
     fun searchBreed(breedAttributes: BreedAttributes): MutableStateFlow<List<Breed>>
     fun deleteBreed(breed: Breed)

}