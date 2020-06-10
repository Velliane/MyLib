package com.menard.mylib.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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

    @Insert
    fun insertBook(book: Book): Long

    @Update
    fun updateBook(book: Book): Int

    @Query("DELETE FROM Book WHERE id_book = :id_book")
    fun deleteBook(id_book: Int): Int
}