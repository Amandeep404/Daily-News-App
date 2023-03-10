package com.example.dailynews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dailynews.NewsViewModel
import com.example.dailynews.repository.NewsRepository

class NewsViewModelFactory(
    val newsRepository : NewsRepository
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }

}