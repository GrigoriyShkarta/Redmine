package com.example.redmine.network

import retrofit2.http.GET

interface RedmineApiService {
    @GET("issues.json?key=7514b71f69871b3ea479f376ae8c27d6a75948bd")
    fun getMyIssues(): String
}

