package com.example.domain.usecaseTest

import com.example.domain.repository.MeetingRepositoryStub
import com.example.domain.usecase.GetMeetingListUseCaseStub
import com.example.domain.usecase.interfaces.IGetMeetingListUseCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetMeetingListUseCaseTest {
    private lateinit var useCase: IGetMeetingListUseCase

    @Before
    fun setUp() {
        val stubRepository = MeetingRepositoryStub()
        useCase = GetMeetingListUseCaseStub(stubRepository)
    }

    @Test
    fun `meeting list not empty`() = runTest {
        val meetingList = useCase().first()
        assertTrue(meetingList.isNotEmpty())
    }
}