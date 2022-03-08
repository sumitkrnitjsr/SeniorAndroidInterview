package com.interviewprep.seniorandroiddev.model

class BreedSelector {

    fun findBreed(attributes: BreedAttributes, name: String = "None"):Breed {
        return Breed(attributes = attributes, name = name)
    }
}