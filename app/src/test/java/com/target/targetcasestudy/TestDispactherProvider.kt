package com.target.targetcasestudy

import com.target.targetcasestudy.di.DispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@ExperimentalCoroutinesApi
class TestDispatcherProvider : DispatcherProvider {
    val testDispatcher = TestCoroutineDispatcher()

    override val io = testDispatcher
    override val main = testDispatcher
    override val default = testDispatcher
    override val unconfined = testDispatcher
}