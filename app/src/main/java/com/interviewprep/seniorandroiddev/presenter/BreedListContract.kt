package com.interviewprep.seniorandroiddev.presenter

interface  BreedListContract {

    interface ListPresenter {
        fun attributesSelected(attributes: BreedAttributes)
    }

    interface ListView {
        fun showSelectedBreed(breed: Breed)
    }
}