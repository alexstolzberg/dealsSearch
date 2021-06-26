package com.target.targetcasestudy.di

import android.content.Context
import com.target.targetcasestudy.App
import com.target.targetcasestudy.api.DealsRepository
import com.target.targetcasestudy.api.DealsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): App = app as App

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.target.com/mobile_case_study_deals/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideDealsService(retrofit: Retrofit): DealsService =
        retrofit.create(DealsService::class.java)

    @Singleton
    @Provides
    fun provideDealsRepository(dealsService: DealsService) = DealsRepository(dealsService)
}