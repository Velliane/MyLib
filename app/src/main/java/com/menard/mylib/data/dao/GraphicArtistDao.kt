package com.menard.mylib.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.menard.mylib.model.GraphicArtist

@Dao
interface GraphicArtistDao {

    @Query("SELECT * FROM GraphicArtist")
    fun getAllGraphics(): LiveData<List<GraphicArtist>>

    @Query("SELECT * FROM GraphicArtist WHERE id_graphic = :id_graphic")
    fun getGraphicFromId(id_graphic: Int): LiveData<List<GraphicArtist>>

    @Insert
    fun insertGraphic(graphicArtist: GraphicArtist): Long

    @Update
    fun updateGraphic(graphicArtist: GraphicArtist): Int

    @Query("DELETE FROM Book WHERE id_book = :id_graphic")
    fun deleteGraphic(id_graphic: Int): Int
}