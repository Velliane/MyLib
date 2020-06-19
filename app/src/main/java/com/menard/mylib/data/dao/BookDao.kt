package com.menard.mylib.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.menard.mylib.model.Book

/**
 *
 */

@Dao
interface BookDao {

    @Query("SELECT * FROM Book")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM Book WHERE id_book = :id_book")
    fun getBookFromId(id_book: Int): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book): Long

    @Update
    fun updateBook(book: Book): Int

    @Query("DELETE FROM Book WHERE id_book = :id_book")
    fun deleteBook(id_book: Int): Int
}