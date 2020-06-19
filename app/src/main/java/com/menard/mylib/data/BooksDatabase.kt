package com.menard.mylib.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.menard.mylib.data.dao.AuthorDao
import com.menard.mylib.data.dao.BookDao
import com.menard.mylib.data.dao.EditorDao
import com.menard.mylib.data.dao.GraphicArtistDao
import com.menard.mylib.model.Author
import com.menard.mylib.model.Book
import com.menard.mylib.model.Editor
import com.menard.mylib.model.GraphicArtist

@Database(
    entities = [Book::class, Author::class, Editor::class, GraphicArtist::class],
    version = 1,
    exportSchema = false
)

abstract class BooksDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao
    abstract fun authorDao(): AuthorDao
    abstract fun editorDao(): EditorDao
    abstract fun graphicDao(): GraphicArtistDao

    companion object {
        private var INSTANCE: BooksDatabase? = null


        fun getInstance(context: Context): BooksDatabase {
            if (INSTANCE == null) {
                synchronized(BooksDatabase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            BooksDatabase::class.java,
                            "Books.db"
                        ).setJournalMode(JournalMode.TRUNCATE)
                            .build()
                    }
                }
            }
            return INSTANCE as BooksDatabase
        }

        fun destroyInstance(){
            INSTANCE = null
        }


    }

}

