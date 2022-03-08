package com.interviewprep.seniorandroiddev.presenter

import com.interviewprep.seniorandroiddev.MainActivity
import com.interviewprep.seniorandroiddev.model.BreedAttributes
import com.interviewprep.seniorandroiddev.model.SearchRepository
import com.interviewprep.seniorandroiddev.model.room.BreedRepository

class BreedPresenter(private val repository: SearchRepository = BreedRepository()): BaseListPresenter<BreedListContract.ListView>(), BreedListContract.ListPresenter {
    override fun attributesSelected(attributes: BreedAttributes) =
         repository.searchBreed(attributes.maxTemperature?.toInt(),
        attributes.monthlyBudgetUSD?.toInt(), attributes.purpose, attributes.dailyTimeMin?.toInt())

}