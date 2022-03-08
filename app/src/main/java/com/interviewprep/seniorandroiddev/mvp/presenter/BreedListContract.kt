package com.interviewprep.seniorandroiddev.mvp.presenter

import com.interviewprep.seniorandroiddev.mvp.model.Breed
import com.interviewprep.seniorandroiddev.mvp.model.BreedAttributes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface  BreedListContract {

    interface ListPresenter {
        fun attributesSelected(attributes: BreedAttributes): Flow<List<Breed>>
    }

    interface ListView {
    }
}