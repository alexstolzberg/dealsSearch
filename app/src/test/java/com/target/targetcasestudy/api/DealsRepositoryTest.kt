package com.target.targetcasestudy.api

import com.nhaarman.mockitokotlin2.whenever
import com.target.targetcasestudy.data.StaticData
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import java.lang.IllegalStateException

class DealsRepositoryTest {

    private val mockDealsService: DealsService = mock(DealsService::class.java)
    private lateinit var dealsRepository: DealsRepository

    @Before
    fun setUp() {
        dealsRepository = DealsRepository(mockDealsService)
    }

    @Test
    fun `test successful response for getDeals endpoint`() {
        runBlocking {
            whenever(mockDealsService.getDeals()).thenReturn(StaticData.dealsResponse)

            val dealsResult = dealsRepository.loadDeals()
            assertTrue(dealsResult is Success)

            val deals = (dealsResult as Success).data
            assertEquals(StaticData.dealsResponse.products, deals)
        }
    }

    @Test
    fun `test error from getDeals endpoint`() {
        runBlocking {
            whenever(mockDealsService.getDeals()).thenThrow(IllegalStateException("This is an error!"))

            val dealsResult = dealsRepository.loadDeals()
            assertTrue(dealsResult is Error)
        }
    }

    @Test
    fun `test successful response for getDeal endpoint`() {
        runBlocking {
            whenever(mockDealsService.getDeal(anyInt())).thenReturn(StaticData.dealsResponse.products[0])

            val dealResult = dealsRepository.loadDeal(id = 1)
            assertTrue(dealResult is Success)

            val deal = (dealResult as Success).data
            assertEquals(StaticData.dealsResponse.products[0], deal)
        }
    }

    @Test
    fun `test error from getDeal endpoint`() {
        runBlocking {
            whenever(mockDealsService.getDeal(anyInt())).thenThrow(IllegalStateException("This is an error!"))

            val dealResult = dealsRepository.loadDeal(id = 1)
            assertTrue(dealResult is Error)
        }
    }
}