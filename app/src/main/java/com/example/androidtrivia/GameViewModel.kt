package com.example.androidtrivia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    var question = MutableLiveData<Questions>()
    private lateinit var questions: ArrayList<Questions>

    var isfinished  = MutableLiveData<Boolean>()

    var index = 0

    init {
        questions = getQuestions()
        question.value = questions[index]
        index++
    }

    fun getNextQuestion() {
        if (index==questions.size){
            isfinished.value = true
            return
        }
        question.value = questions[index++]

    }



}