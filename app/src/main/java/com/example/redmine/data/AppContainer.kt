package com.example.redmine.data

import com.example.redmine.network.RedmineApiService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

interface AppContainer {
    val redmineRepository: RedmineRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://rm.wwind.ua"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: RedmineApiService by lazy {
        retrofit.create(RedmineApiService::class.java)
    }

    override val redmineRepository: RedmineRepository by lazy {
        NetworkRedmineRepository(retrofitService)
    }
}