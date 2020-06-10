package com.menard.mylib.repositories

import androidx.lifecycle.LiveData
import com.menard.mylib.database.dao.BookDao
import com.menard.mylib.model.Book

/**
 * Repository of the class BookDao
 */

class BookDataRepository(private val bookDao: BookDao) {

    fun getAllBooks(): LiveData<List<Book>>{
        return bookDao.getAllBooks()
    }

    fun getBookFromId(id_book: Int): LiveData<List<Book>>{
        return bookDao.getBookFromId(id_book)
    }

    fun insertBook(book: Book): Long{
        return bookDao.insertBook(book)
    }

    fun updateBook(book: Book): Int{
        return bookDao.updateBook(book)
    }

    fun deleteBook(id_book: Int): Int{
        return bookDao.deleteBook(id_book)
    }

}