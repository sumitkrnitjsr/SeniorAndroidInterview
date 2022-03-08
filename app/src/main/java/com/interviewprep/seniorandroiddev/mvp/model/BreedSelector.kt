package com.interviewprep.seniorandroiddev.mvp.model

class BreedSelector {

    fun findBreed(attributes: BreedAttributes, name: String = "None"): Breed {
        return Breed(attributes = attributes, name = name)
    }
}