package com.interviewprep.seniorandroiddev.presenter

import com.interviewprep.seniorandroiddev.mvp.model.SearchRepository
import com.interviewprep.seniorandroiddev.mvp.presenter.BreedPresenter
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BreedPresenterTest {

    private lateinit var presenter: BreedPresenter
    @Mock
    lateinit var mockRepository: SearchRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = BreedPresenter(mockRepository)
    }

    @Test
    fun whenClickSubmitBtn_shouldCallAttributesSelected() {
        // TO-DO Implementation
    }
}