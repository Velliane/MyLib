package com.menard.mylib.utils.injections

import android.content.Context
import com.menard.mylib.data.BooksDatabase
import com.menard.mylib.data.repositories.AuthorDataRepository
import com.menard.mylib.data.repositories.BookDataRepository
import com.menard.mylib.data.repositories.EditorDataRepository
import com.menard.mylib.data.repositories.GraphicArtistRepository
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Injection {

    companion object {

        fun provideBookDataSource(context: Context): BookDataRepository {
            val database = BooksDatabase.getInstance(context)
            return BookDataRepository(database.bookDao())
        }

        fun provideAuthorDataSource(context: Context): AuthorDataRepository {
            val database = BooksDatabase.getInstance(context)
            return AuthorDataRepository(database.authorDao())
        }

        fun provideEditorDataSource(context: Context): EditorDataRepository {
            val database = BooksDatabase.getInstance(context)
            return EditorDataRepository(database.editorDao())
        }

        fun provideGraphicArtistDataSource(context: Context): GraphicArtistRepository {
            val database = BooksDatabase.getInstance(context)
            return GraphicArtistRepository(database.graphicDao())
        }

        fun provideExecutor(): Executor {
            return Executors.newSingleThreadExecutor()
        }

        fun provideViewModelFactory(context: Context): ViewModelFactory {
            val bookDataRepository = provideBookDataSource(context)
            val authorDataRepository = provideAuthorDataSource(context)
            val editorDataRepository = provideEditorDataSource(context)
            val graphicArtistRepository = provideGraphicArtistDataSource(context)
            val executor = provideExecutor()
            return ViewModelFactory(bookDataRepository, authorDataRepository, editorDataRepository, graphicArtistRepository, executor)
        }

    }
}