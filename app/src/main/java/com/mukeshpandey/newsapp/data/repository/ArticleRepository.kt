package com.mukeshpandey.newsapp.data.repository

import com.mukeshpandey.newsapp.data.local.ArticleDatabase
import com.mukeshpandey.newsapp.data.model.Article
import com.mukeshpandey.newsapp.data.remote.NewsApi
import com.mukeshpandey.newsapp.data.util.Constants.Companion.API_KEY
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val database: ArticleDatabase,
    private val newsApi: NewsApi,
) {

    suspend fun getAllArticles(searchQuery: String, pageNumber: Int) =
        newsApi.getNews(searchQuery, pageNumber, API_KEY)

    fun getFavoriteArticles() = database.articleDao().getArticles()

    suspend fun insert(article: Article) = database.articleDao().insert(article)

    suspend fun deleteArticle(article: Article) = database.articleDao().deleteArticle(article)
}