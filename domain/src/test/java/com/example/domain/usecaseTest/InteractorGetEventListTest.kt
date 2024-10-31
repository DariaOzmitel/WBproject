package com.example.domain.usecaseTest

import com.example.domain.repository.EventsRepositoryStub
import com.example.domain.usecase.GetEventListUseCaseStub
import com.example.domain.usecase.interfaces.IGetEventListUseCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class InteractorGetEventListTest {
    private lateinit var useCase: IGetEventListUseCase

    @Before
    fun setUp() {
        val stubRepository = EventsRepositoryStub()
        useCase = GetEventListUseCaseStub(stubRepository)
    }

    @Test
    fun `meeting list not empty`() = runTest {
        val meetingList = useCase().first()
        assertTrue(meetingList.isNotEmpty())
    }
}