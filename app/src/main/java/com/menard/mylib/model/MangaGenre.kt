package com.menard.mylib.model

enum class MangaGenre(val style: String) {
    SHONEN("Shonen"),
    SEINEN("Seinen"),
    SHOJO("Shojo"),
    JOSEI("Josei"),
    YURI("Yuri"),
    YAOI("Yaoi"),
    HENTAI("Hentaï");

    fun getMangaGenre():String{
        return style
    }
}