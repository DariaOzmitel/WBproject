package com.example.domain.usecaseTest

import com.example.domain.mockData.mockListEvents
import com.example.domain.repository.EventsRepositoryStub
import com.example.domain.usecase.GetEventByIdUseCaseStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetEventUseCaseTest {
    private lateinit var useCase: GetEventByIdUseCaseStub

    @Before
    fun setUp() {
        val stubRepository = EventsRepositoryStub()
        useCase = GetEventByIdUseCaseStub(stubRepository)
    }

    @Test
    fun `meeting received by id correctly`() = runTest {
        val testId = 1
        val expectedMeeting = mockListEvents.first { meeting -> meeting.id == testId }
        val actualMeeting = useCase(testId).first()
        assertEquals(expectedMeeting, actualMeeting)
    }
}