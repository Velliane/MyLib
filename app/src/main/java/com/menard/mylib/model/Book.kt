package com.menard.mylib.model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


//    foreignKeys = [ForeignKey(
//        entity = Author::class,
//        parentColumns = arrayOf("id_author"),
//        childColumns = arrayOf("author_id")
//    ), (ForeignKey(
//        entity = GraphicArtist::class,
//        parentColumns = arrayOf("id_graphic"),
//        childColumns = arrayOf("graphic_id")
//    )), (ForeignKey(
//        entity = Editor::class,
//        parentColumns = arrayOf("id_editor"),
//        childColumns = arrayOf("editor_id")
//    ))]


@Entity
data class Book(

    @PrimaryKey(autoGenerate = true)
    var id_book: Int = 0,

    var isbn: Int = 0,
    var title: String = "",
    var synopsis: String? = "",
    var comment: String? = "",
    var note: Int? = 0,
    var category: String? = "",
    var genre: String? = "",

    var author_id: Int? = 0,
    var graphic_id: Int? = 0,
    var editor_id: Int? = 0

)