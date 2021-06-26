package com.target.targetcasestudy.api

/**
 * This class encapsulates results from a service and wraps them in either a success state or error state
 */
sealed class ApiResult<out T : Any>
class Success<out T : Any>(val data: T) : ApiResult<T>()
class Error(private val exception: Throwable,
            val message: String? = exception.localizedMessage) :
    ApiResult<Nothing>()