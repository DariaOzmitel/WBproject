package com.example.domain.usecaseTest

import com.example.domain.mockData.mockUser
import com.example.domain.repository.MeetingRepositoryStub
import com.example.domain.usecase.GetUserFlowUseCaseStub
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetUserFlowUseCaseTest {
    private lateinit var useCase: IGetUserFlowUseCase

    @Before
    fun setUp() {
        val stubRepository = MeetingRepositoryStub()
        useCase = GetUserFlowUseCaseStub(stubRepository)
    }

    @Test
    fun `user received correctly`() = runTest {
        val expectedUser = mockUser
        val actualUser = useCase().first()
        assertEquals(expectedUser, actualUser)
    }
}