package com.example.redmine.data

import com.example.redmine.network.RedmineApiService
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer {
    val redmineRepository: RedmineRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://rm.wwind.ua"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: RedmineApiService by lazy {
        retrofit.create(RedmineApiService::class.java)
    }

    override val redmineRepository: RedmineRepository by lazy {
        NetworkRedmineRepository(retrofitService)
    }
}