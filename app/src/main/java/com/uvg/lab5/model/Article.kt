package com.uvg.lab5.model

data class Article(
    val author: String,
    val title: String,
    val excerpt: String,
    val readingMinutes: Int,
    val date: String
)