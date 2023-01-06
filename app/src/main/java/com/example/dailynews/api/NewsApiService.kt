package com.example.dailynews.api

import com.example.dailynews.model.NewsApiResponse
import com.example.dailynews.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        country : String = "in",
        @Query("page")
        pageNumber : Int = 1,
        @Query("apikey")
        apikey : String = API_KEY
    ): Response<NewsApiResponse>

    @GET("everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery : String ,
        @Query("page")
        pageNumber : Int = 1,
        @Query("apikey")
        apikey : String = API_KEY
    ): Response<NewsApiResponse>
}