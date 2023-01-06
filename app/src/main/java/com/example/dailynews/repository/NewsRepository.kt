package com.example.dailynews.repository

import androidx.room.Query
import com.example.dailynews.api.RetrofitInstance
import com.example.dailynews.database.ArticleDatabase
import com.example.dailynews.model.Article

//We cannot use constructor parameters by default for our own ViewModel but we need our newsRepository in our ViewModel
// then we need to create ViewModel-Provider-Factory to define how our own ViewModel should be created
class   NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber : Int)  =
        RetrofitInstance.newsApi.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.newsApi.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticlesDao().upsert(article)

    fun getSavedNews() = db.getArticlesDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticlesDao().deleteArticle(article)
}