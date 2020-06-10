package com.menard.mylib.injections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.menard.mylib.repositories.AuthorDataRepository
import com.menard.mylib.repositories.BookDataRepository
import com.menard.mylib.repositories.EditorDataRepository
import com.menard.mylib.repositories.GraphicArtistRepository
import com.menard.mylib.view_model.BookViewModel
import java.lang.IllegalArgumentException
import java.util.concurrent.Executor

class ViewModelFactory(
    private val bookDataRepository: BookDataRepository,
    private val authorDataRepository: AuthorDataRepository,
    private val editorDataRepository: EditorDataRepository,
    private val graphicArtistRepository: GraphicArtistRepository,
    private val executor: Executor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BookViewModel::class.java)){
            return BookViewModel(bookDataRepository, authorDataRepository, editorDataRepository, graphicArtistRepository, executor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}