package com.menard.mylib.model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Editor(
    @PrimaryKey(autoGenerate = true)
    var id_editor: Int,

    var name: String,
    var website: String?
)