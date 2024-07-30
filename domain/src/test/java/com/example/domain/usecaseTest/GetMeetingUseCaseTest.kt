package com.example.domain.usecaseTest

import com.example.domain.mockData.mockListMeetings
import com.example.domain.repository.MeetingRepositoryStub
import com.example.domain.usecase.GetMeetingUseCaseStub
import com.example.domain.usecase.interfaces.IGetMeetingUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetMeetingUseCaseTest {
    private lateinit var useCase: IGetMeetingUseCase

    @Before
    fun setUp() {
        val stubRepository = MeetingRepositoryStub()
        useCase = GetMeetingUseCaseStub(stubRepository)
    }

    @Test
    fun `meeting received by id correctly`() = runTest {
        val testId = 1
        val expectedMeeting = mockListMeetings.first { meeting -> meeting.id == testId }
        val actualMeeting = useCase(testId).first()
        assertEquals(expectedMeeting, actualMeeting)
    }
}