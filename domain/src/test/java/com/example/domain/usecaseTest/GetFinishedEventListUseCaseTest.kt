package com.example.domain.usecaseTest

import com.example.domain.repository.EventsRepositoryStub
import com.example.domain.usecase.GetFinishedEventsListUseCaseStub
import com.example.domain.usecase.interfaces.IGetFinishedEventsListUseCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetFinishedEventListUseCaseTest {
    private lateinit var useCase: IGetFinishedEventsListUseCase

    @Before
    fun setUp() {
        val stubRepository = EventsRepositoryStub()
        useCase = GetFinishedEventsListUseCaseStub(stubRepository)
    }

    @Test
    fun `finishedMeeting list not empty`() = runTest {
        val finishedMeetingList = useCase().first()
        assertTrue(finishedMeetingList.isNotEmpty())
    }
}