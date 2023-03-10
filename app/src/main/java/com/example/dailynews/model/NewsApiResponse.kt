package com.example.dailynews.model

data class NewsApiResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)