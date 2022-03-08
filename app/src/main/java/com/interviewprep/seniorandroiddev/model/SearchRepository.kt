package com.interviewprep.seniorandroiddev.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface SearchRepository {

     suspend fun addBreed(breed: Breed)
     fun searchBreed(temperature: Int?, budget:Int?, purpose:String?, time:Int?): Flow<List<Breed>>
     suspend fun deleteBreed(breed: Breed)

}