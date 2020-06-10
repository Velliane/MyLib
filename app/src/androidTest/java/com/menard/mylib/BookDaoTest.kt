package com.menard.mylib

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.menard.mylib.database.BooksDatabase
import com.menard.mylib.model.Author
import com.menard.mylib.model.Book
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BookDaoTest {

    private var database: BooksDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context, BooksDatabase::class.java)
        .allowMainThreadQueries()
        .build()

    companion object {
        val BOOK_ID: Int = 1
        val BOOK_DEMO: Book =
            Book(BOOK_ID, 16353244, "Mon livre", null, null, 5, "Roman", "Thriller", null, null, null)
    }

    @get:Rule
    open val instantTaskExecutorRule = InstantTaskExecutorRule()

//    @Before
//    fun initDb() {
//        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context, BooksDatabase::class.java)
//            .allowMainThreadQueries()
//            .build()
//    }

    @After
    fun closeDb() {
        database.close()
    }

    // TESTS //
    @Test
    @Throws(InterruptedException::class)
    fun insertAndGetBook() {
        database.bookDao().insertBook(BOOK_DEMO)

        val book = LiveDataTestUtil.getValue(database.bookDao().getBookFromId(BOOK_ID))
        assertTrue(book[0].title.equals(BOOK_DEMO.title))
    }
}