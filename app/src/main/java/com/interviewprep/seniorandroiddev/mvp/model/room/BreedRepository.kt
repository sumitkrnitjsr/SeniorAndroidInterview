package com.interviewprep.seniorandroiddev.mvp.model.room

import com.interviewprep.seniorandroiddev.mvp.BaseApplication
import com.interviewprep.seniorandroiddev.mvp.model.Breed
import com.interviewprep.seniorandroiddev.mvp.model.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class BreedRepository: SearchRepository {
    private val breedDAO: BreedDAO = BaseApplication.database.breedDao()

    override suspend fun addBreed(breed: Breed)  = withContext(Dispatchers.IO + NonCancellable) {
        breedDAO.insert(breed)
    }

    override fun searchBreed(
        temperature: Int?,
        budget: Int?,
        purpose: String?,
        time: Int?
    ): Flow<List<Breed>> =
        breedDAO.searchBreed(temperature = temperature?.toInt(),budget = budget?.toInt(), purpose = purpose, time = time?.toInt())

    override suspend fun deleteBreed(breed: Breed)= withContext(Dispatchers.IO + NonCancellable) {
        breedDAO.delete(breed)
    }
}