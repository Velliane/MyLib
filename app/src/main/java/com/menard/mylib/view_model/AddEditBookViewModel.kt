package com.menard.mylib.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.menard.mylib.model.Book
import com.menard.mylib.data.repositories.AuthorDataRepository
import com.menard.mylib.data.repositories.BookDataRepository
import com.menard.mylib.data.repositories.EditorDataRepository
import com.menard.mylib.data.repositories.GraphicArtistRepository
import java.util.concurrent.Executor

class AddEditBookViewModel(
    private val bookDataRepository: BookDataRepository,
    private val authorDataRepository: AuthorDataRepository,
    private val editorDataRepository: EditorDataRepository,
    private val graphicArtistRepository: GraphicArtistRepository,
    private val executor: Executor
) : ViewModel() {

    //-- For Books --

    fun getBooks(): LiveData<List<Book>>{
        return bookDataRepository.getAllBooks()
    }

    fun insertBook(book: Book){
        executor.execute { bookDataRepository.insertBook(book) }
    }

    fun getBookById(id_book: Int){
        executor.execute { bookDataRepository.getBookFromId(id_book) }
    }

    fun updateBook(book: Book){
        executor.execute { bookDataRepository.updateBook(book) }
    }

    fun deleteBook(id_book: Int){
        executor.execute { bookDataRepository.deleteBook(id_book) }
    }

}