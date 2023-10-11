package com.example.redmine.model

data class Redmine(
    val id: Int,
    val tracker: Tracker,
    val subject: String,
    val author: Author,
    val priority: Priority,
    val version: Version,
    val estimatedHours: Double,
    val description: String,
    val status: Status
)

data class Tracker(
    val id: Int,
    val name: String
)

data class Author(
    val id: Int,
    val name: String
)

data class Priority(
    val id: Int,
    val name: String
)

data class Version(
    val id: Int,
    val name: String
)

data class Status(
    val id: Int,
    val name: String
)
