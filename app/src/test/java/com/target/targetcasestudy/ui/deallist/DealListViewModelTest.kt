package com.target.targetcasestudy.ui.deallist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import com.target.targetcasestudy.MainCoroutineRule
import com.target.targetcasestudy.TestDispatcherProvider
import com.target.targetcasestudy.api.DealsRepository
import com.target.targetcasestudy.api.Error
import com.target.targetcasestudy.api.Success
import com.target.targetcasestudy.data.DealItem
import com.target.targetcasestudy.data.StaticData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import java.lang.IllegalStateException

@ExperimentalCoroutinesApi
class DealListViewModelTest {

    private val dispatchers = TestDispatcherProvider()
    private val testDispatcher = dispatchers.testDispatcher

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule(testDispatcher)

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val dealsRepository = Mockito.mock(DealsRepository::class.java)
    private lateinit var dealsViewModel: DealListViewModel

    @Before
    fun setUp() {
        dealsViewModel = DealListViewModel(dealsRepository)
    }

    @Test
    fun `live data is updated correctly when deals are loaded`() {
        testDispatcher.runBlockingTest {
            whenever(dealsRepository.loadDeals()).thenReturn(Success(StaticData.deals))

            dealsViewModel.getDeals()

            val dealsLiveData = dealsViewModel.deals
            assertEquals(dealsLiveData.value, StaticData.deals)
        }
    }

    @Test
    fun `live data is empty when there is an error loading deals`() {
        testDispatcher.runBlockingTest {
            whenever(dealsRepository.loadDeals()).thenReturn(Error(IllegalStateException("This is an error!")))

            dealsViewModel.getDeals()

            val dealsLiveData = dealsViewModel.deals
            assertEquals(emptyList<DealItem>(), dealsLiveData.value)
        }
    }
}