package com.example.domain.usecaseTest

import com.example.domain.mockData.mockCommunityList
import com.example.domain.repository.MeetingRepositoryStub
import com.example.domain.usecase.GetCommunityUseCaseStub
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetCommunityUseCaseTest {
    private lateinit var useCase: IGetCommunityUseCase

    @Before
    fun setUp() {
        val stubRepository = MeetingRepositoryStub()
        useCase = GetCommunityUseCaseStub(stubRepository)
    }

    @Test
    fun `community received by id correctly`() = runTest {
        val testId = 1
        val expectedCommunity = mockCommunityList.first { community -> community.id == testId }
        val actualCommunity = useCase(testId).first()
        assertEquals(expectedCommunity, actualCommunity)
    }
}