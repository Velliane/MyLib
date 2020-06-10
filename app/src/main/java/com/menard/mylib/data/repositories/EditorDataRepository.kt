package com.menard.mylib.data.repositories

import androidx.lifecycle.LiveData
import com.menard.mylib.data.dao.EditorDao
import com.menard.mylib.model.Editor

class EditorDataRepository (private val editorDao: EditorDao){

    fun getAllEditor(): LiveData<List<Editor>>{
        return editorDao.getAllEditors()
    }

    fun getEditorFromId(id_editor: Int): LiveData<List<Editor>>{
        return editorDao.getEditorFromId(id_editor)
    }

    fun insertEditor(editor: Editor): Long{
        return editorDao.insertEditor(editor)
    }

    fun updateEditor(editor: Editor): Int{
        return editorDao.updateEditor(editor)
    }

    fun deleteEditor(id_editor: Int): Int{
        return editorDao.deleteEditor(id_editor)
    }
}