package com.example.androidtrivia

data class Questions (
    val id : Int,
    val title : String,
    val options : List<String>,
    val answer : Int
)