package com.example.dailynews.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.dailynews.MainActivity
import com.example.dailynews.NewsViewModel
import com.example.dailynews.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*


class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    val args : ArticleFragmentArgs by navArgs()

    private var clicked = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        val article = args.article
        webView.apply {
            webViewClient =  WebViewClient() // to make sure that page loads inside the application and don't load in the standard browser of the phone
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            if (clicked == 0){
                viewModel.saveArticle(article)
                fab.setColorFilter(Color.RED)
                Snackbar.make(view, "Article Saved Successfully", Snackbar.LENGTH_SHORT).show()

                clicked++
            }else Toast.makeText(context, "Article already saved", Toast.LENGTH_SHORT).show()

        }

    }



}