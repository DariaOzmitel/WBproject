package com.example.domain.usecaseTest

import com.example.domain.repository.CommunityRepositoryStub
import com.example.domain.usecase.GetCommunityListUseCaseStub
import com.example.domain.usecase.interfaces.IGetCommunityListUseCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetCommunityListUseCaseTest {
    private lateinit var useCase: IGetCommunityListUseCase

    @Before
    fun setUp() {
        val stubRepository = CommunityRepositoryStub()
        useCase = GetCommunityListUseCaseStub(stubRepository)
    }

    @Test
    fun `community list not empty`() = runTest {
        val communityList = useCase().first()
        assertTrue(communityList.isNotEmpty())
    }
}