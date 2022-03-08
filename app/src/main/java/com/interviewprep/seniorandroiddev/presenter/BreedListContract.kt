package com.interviewprep.seniorandroiddev.presenter

import com.interviewprep.seniorandroiddev.model.Breed
import com.interviewprep.seniorandroiddev.model.BreedAttributes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface  BreedListContract {

    interface ListPresenter {
        fun attributesSelected(attributes: BreedAttributes): Flow<List<Breed>>
    }

    interface ListView {
    }
}