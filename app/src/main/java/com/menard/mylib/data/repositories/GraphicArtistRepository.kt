package com.menard.mylib.data.repositories

import androidx.lifecycle.LiveData
import com.menard.mylib.data.dao.GraphicArtistDao
import com.menard.mylib.model.GraphicArtist

class GraphicArtistRepository(private val graphicArtistDao: GraphicArtistDao) {

    fun getAllEditor(): LiveData<List<GraphicArtist>> {
        return graphicArtistDao.getAllGraphics()
    }

    fun getEditorFromId(id_graphic: Int): LiveData<List<GraphicArtist>> {
        return graphicArtistDao.getGraphicFromId(id_graphic)
    }

    fun insertEditor(graphicArtist: GraphicArtist): Long{
        return graphicArtistDao.insertGraphic(graphicArtist)
    }

    fun updateEditor(graphicArtist: GraphicArtist): Int{
        return graphicArtistDao.updateGraphic(graphicArtist)
    }

    fun deleteEditor(id_graphic: Int): Int{
        return graphicArtistDao.deleteGraphic(id_graphic)
    }
}