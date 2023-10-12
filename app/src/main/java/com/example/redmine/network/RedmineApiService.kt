package com.example.redmine.network

import com.example.redmine.model.Redmine
import retrofit2.http.GET

private const val KEY = "key=7514b71f69871b3ea479f376ae8c27d6a75948bd"

interface RedmineApiService {
    @GET("issues.json?$KEY")
    fun getMyIssues(): List<Redmine>
}

