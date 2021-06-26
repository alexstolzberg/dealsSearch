package com.target.targetcasestudy.api

import com.target.targetcasestudy.data.DealItem
import com.target.targetcasestudy.data.DealsResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Endpoints for the Target deals service
 */
interface DealsService {

    @GET("deals")
    suspend fun getDeals(): DealsResponse

    @GET("deals/{id}")
    suspend fun getDeal(@Path("id") id: Int): DealItem
}

