package com.example.domain.usecaseTest

import com.example.domain.repository.MeetingRepositoryStub
import com.example.domain.usecase.GetFinishedMeetingListUseCaseStub
import com.example.domain.usecase.interfaces.IGetFinishedMeetingListUseCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetFinishedMeetingListUseCaseTest {
    private lateinit var useCase: IGetFinishedMeetingListUseCase

    @Before
    fun setUp() {
        val stubRepository = MeetingRepositoryStub()
        useCase = GetFinishedMeetingListUseCaseStub(stubRepository)
    }

    @Test
    fun `finishedMeeting list not empty`() = runTest {
        val finishedMeetingList = useCase().first()
        assertTrue(finishedMeetingList.isNotEmpty())
    }
}