package com.target.targetcasestudy.api

import com.target.targetcasestudy.data.DealItem
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

/**
 * Used to load data from the deals service
 */
class DealsRepository @Inject constructor(private val dealsService: DealsService) {

    suspend fun loadDeals(): ApiResult<List<DealItem>> = try {
        val result = dealsService.getDeals().products
        Success(result)
    } catch (e: Exception) {
        // This error handling could be expanded to handle errors different based on error code
        Timber.e(e, "Error when loading deals")
        Error(e)
    }

    suspend fun loadDeal(id: Int): ApiResult<DealItem> = try {
        val result = dealsService.getDeal(id)
        Success(result)
    } catch (e: Exception) {
        // This error handling could be expanded to handle errors different based on error code
        Timber.e(e, "Error when loading deal with id = $id")
        Error(e)
    }

    // TODO: Store data in a Room database
}