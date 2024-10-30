package com.example.domain.usecaseTest

import com.example.domain.repository.EventsRepositoryStub
import com.example.domain.usecase.InteractorGetMeetingListStub
import com.example.domain.usecase.interfaces.IInteractorGetMeetingList
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class InteractorGetEventListTest {
    private lateinit var useCase: IInteractorGetMeetingList

    @Before
    fun setUp() {
        val stubRepository = EventsRepositoryStub()
        useCase = InteractorGetMeetingListStub(stubRepository)
    }

    @Test
    fun `meeting list not empty`() = runTest {
        val meetingList = useCase().first()
        assertTrue(meetingList.isNotEmpty())
    }
}