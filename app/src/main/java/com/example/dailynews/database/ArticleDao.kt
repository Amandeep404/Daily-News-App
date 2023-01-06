package com.example.dailynews.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dailynews.model.Article

// onConflict is used when if the article already exists in the database

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long // this function deals with updating and insertion of data

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>> // if article inside the list of " Article " changes then the LiveData wil notify all of its observers that subscribes to changes of the live data

    @Delete
    suspend fun deleteArticle(article: Article)
}