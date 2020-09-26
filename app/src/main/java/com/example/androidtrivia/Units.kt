package com.example.androidtrivia

fun getQuestions() : ArrayList<Questions>{

    val op1 = arrayListOf<String>("hasan","ali","hamid","akbar")
    val question1 = Questions(1,"whats your name ? ", op1 , 2)


    val op2 = arrayListOf<String>("Red","white","brown","blue")
    val question2 = Questions(1,"whats your name ? ", op2 , 2)

    return arrayListOf(question1,question2)
}