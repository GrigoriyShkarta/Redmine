package com.example.redmine.data

import com.example.redmine.model.Redmine
import com.example.redmine.network.RedmineApiService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface RedmineRepository {
    suspend fun getMyIssues(): List<Redmine>
}

class NetworkRedmineRepository(
    private val redmineApiService: RedmineApiService
) : RedmineRepository {
    override suspend fun getMyIssues(): List<Redmine> = redmineApiService.getMyIssues()
}