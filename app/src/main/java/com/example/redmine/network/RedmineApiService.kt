package com.example.redmine.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rm.wwind.ua"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface RedmineApiService {
    @GET("issues.json?assigned_to_id=me")
    fun getMyIssues(): String
}

