package com.example.activitylifecycle.Models

import androidx.lifecycle.ViewModel

class QuestionModel :ViewModel() {
    var no1: Int = 0
    var no2: Int = 0
    var name: String = ""

    init{
        generateQuestion()
    }


    fun getAnswer(): Int{
        return no1 + no2
    }

    fun generateQuestion() : String{
        no1 = (Math.random()*100).toInt()
        no2 = (Math.random()*100).toInt()

        return "${no1} + ${no2} = ?"
    }

    fun getQuestion() : String {
        return "${no1} + ${no2} = ?"
    }

    companion object{
        private var instant : QuestionModel?= null

        fun getInstant() =
            instant?: synchronized(QuestionModel::class.java){
                instant?: QuestionModel().also{instant = it}
            }
    }

}