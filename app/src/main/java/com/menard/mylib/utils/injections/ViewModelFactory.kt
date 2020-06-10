package com.menard.mylib.utils.injections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.menard.mylib.data.repositories.AuthorDataRepository
import com.menard.mylib.data.repositories.BookDataRepository
import com.menard.mylib.data.repositories.EditorDataRepository
import com.menard.mylib.data.repositories.GraphicArtistRepository
import com.menard.mylib.view_model.AddEditBookViewModel
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
        if(modelClass.isAssignableFrom(AddEditBookViewModel::class.java)){
            return AddEditBookViewModel(bookDataRepository, authorDataRepository, editorDataRepository, graphicArtistRepository, executor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}