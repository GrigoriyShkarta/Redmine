package com.example.redmine

import android.app.Application
import com.example.redmine.data.AppContainer
import com.example.redmine.data.DefaultAppContainer

class RedmineApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}