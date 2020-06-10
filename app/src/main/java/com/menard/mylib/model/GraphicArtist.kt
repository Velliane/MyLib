package com.menard.mylib.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDate

@Entity

data class GraphicArtist(

    @PrimaryKey(autoGenerate = true)
    var id_graphic: Int,

    var name: String,
    var firstname: String?,
    //var birth_date: LocalDate?,
    var biographie: String?
)