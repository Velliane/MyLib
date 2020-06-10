package com.menard.mylib.model

enum class BookGenre(val genre: String){
    ROMANCE("Romance"),
    THRILLER("Thriller"),
    SF("Science-Fiction"),
    FANTASTIC("Fantastique"),
    DETECTIVE("Policier"),
    POETRY("Poésie"),
    HISTORIC("Historique");


    fun getBookGenre():String{
        return genre
    }

}

