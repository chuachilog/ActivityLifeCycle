package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.activitylifecycle.Models.QuestionModel

class ThirdActivity : AppCompatActivity() {

    private lateinit var myModel : QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val message : TextView = findViewById(R.id.tvMessage)
        val correct : TextView = findViewById(R.id.tvCorrect)

        myModel = QuestionModel.getInstant()

        if (myModel.getAnswer().toString() == intent.getStringExtra("Answer") ){
            message.text = "Congratulations ${myModel.name} , You answer is correct !!!"
        }else{
            message.text = "Sadly ${myModel.name}, You answer is wrong"
            correct.text = "Correct Answer: ${myModel.getAnswer().toString()}"
        }

    }
}