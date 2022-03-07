package com.interviewprep.seniorandroiddev.model

import com.google.common.truth.Truth8.assertThat
import org.junit.Before
import org.junit.Test


class BreedSelectorTest {

    private lateinit var breedSelector: BreedSelector

    @Before
    fun setup(){
        breedSelector = BreedSelector()
    }


    @Test
    fun whenAttributesSelected_shouldShowCorrectBreed() {
        val attributes = BreedAttributes(
            maxTemperature = 50,
            monthlyBudgetUSD = 70,
            purpose = "GUARD",
            dailyTimeMin = 45
        )

        val expectedBreed = Breed(attributes, "Indian Pariah")
        assertThat(expectedBreed).isEqualTo(breedSelector.findBreed(attributes))
    }
}