package com.interviewprep.seniorandroiddev.mvp.presenter

import com.interviewprep.seniorandroiddev.mvp.MainActivity
import com.interviewprep.seniorandroiddev.mvp.model.BreedAttributes
import com.interviewprep.seniorandroiddev.mvp.model.SearchRepository
import com.interviewprep.seniorandroiddev.mvp.model.room.BreedRepository

class BreedPresenter(private val repository: SearchRepository = BreedRepository()): BaseListPresenter<BreedListContract.ListView>(),
    BreedListContract.ListPresenter {
    override fun attributesSelected(attributes: BreedAttributes) =
         repository.searchBreed(attributes.maxTemperature?.toInt(),
        attributes.monthlyBudgetUSD?.toInt(), attributes.purpose, attributes.dailyTimeMin?.toInt())

}