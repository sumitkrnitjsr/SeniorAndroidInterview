package com.interviewprep.seniorandroiddev.model

import com.google.common.truth.Truth.assertThat
import com.interviewprep.seniorandroiddev.mvp.model.Breed
import com.interviewprep.seniorandroiddev.mvp.model.BreedAttributes
import com.interviewprep.seniorandroiddev.mvp.model.BreedSelector
import org.junit.Before
import org.junit.Test


class BreedSelectorTest {

    private lateinit var breedSelector: BreedSelector

    @Before
    fun setup(){
        breedSelector = BreedSelector()
    }


    @Test
    fun whenGivenAttributes_shouldReturnCorrectBreed() {
        val attributes = BreedAttributes(
            maxTemperature = "50",
            monthlyBudgetUSD = "35",
            purpose = "GUARD",
            dailyTimeMin = "45"
        )

        val expectedBreed = Breed(attributes, "Indian Pariah")
        assertThat(expectedBreed).isEqualTo(breedSelector.findBreed(attributes))
    }
}