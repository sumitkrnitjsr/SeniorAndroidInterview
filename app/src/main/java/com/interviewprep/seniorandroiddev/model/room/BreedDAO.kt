package com.interviewprep.seniorandroiddev.model.room

import androidx.room.*
import com.interviewprep.seniorandroiddev.model.Breed
import com.interviewprep.seniorandroiddev.model.BreedAttributes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Dao
interface BreedDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(breed: Breed)

    @Delete
    suspend fun delete(breed: Breed)

    @Query("SELECT * FROM breed_table WHERE maxTemperature <= :temperature AND monthlyBudgetUSD <= :budget AND purpose = :purpose AND dailyTimeMin <= :time")
    fun searchBreed(temperature: Int?, budget:Int?, purpose:String?, time:Int?): Flow<List<Breed>>

}