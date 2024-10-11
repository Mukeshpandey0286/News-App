package com.mukeshpandey.newsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mukeshpandey.newsapp.data.model.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("SELECT * FROM articles")
    fun getArticles(): LiveData<List<Article>>
}