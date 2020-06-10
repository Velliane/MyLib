package com.menard.mylib.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.menard.mylib.model.Author

@Dao
interface AuthorDao {

    @Query("SELECT * FROM Author")
    fun getAllAuthors(): LiveData<List<Author>>

    @Query("SELECT * FROM Author WHERE id_author = :id_author")
    fun getAuthorFromId(id_author: Int): LiveData<List<Author>>

    @Insert
    fun insertAuthor(author: Author): Long

    @Update
    fun updateAuthor(author: Author): Int

    @Query("DELETE FROM Author WHERE id_author = :id_author")
    fun deleteAuthor(id_author: Int): Int
}