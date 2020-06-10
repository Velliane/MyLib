package com.menard.mylib.repositories

import androidx.lifecycle.LiveData
import com.menard.mylib.database.dao.AuthorDao
import com.menard.mylib.model.Author

/**
 * Repository of the class AuthorDao
 */

class AuthorDataRepository(private val authorDao: AuthorDao) {

    fun getAllAuthors():LiveData<List<Author>>{
        return authorDao.getAllAuthors()
    }

    fun getAuthorFromId(id_author:Int): LiveData<List<Author>>{
        return authorDao.getAuthorFromId(id_author)
    }

    fun insertAuthor(author: Author): Long{
        return authorDao.insertAuthor(author)
    }

    fun updateAuthor(author: Author): Int{
        return authorDao.updateAuthor(author)
    }

    fun deleteAuthor(id_author: Int): Int{
        return authorDao.deleteAuthor(id_author)
    }
}