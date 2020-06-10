package com.menard.mylib.data.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.menard.mylib.model.Editor

@Dao
interface EditorDao {

    @Query("SELECT * FROM Editor")
    fun getAllEditors(): LiveData<List<Editor>>

    @Query("SELECT * FROM Editor WHERE id_editor = :id_editor")
    fun getEditorFromId(id_editor: Int): LiveData<List<Editor>>

    @Insert
    fun insertEditor(book: Editor): Long

    @Update
    fun updateEditor(book: Editor): Int

    @Query("DELETE FROM Book WHERE id_book = :id_editor")
    fun deleteEditor(id_editor: Int): Int
}