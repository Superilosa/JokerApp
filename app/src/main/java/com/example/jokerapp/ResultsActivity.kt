package com.example.jokerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        init()
    }
    private fun init(){
        name1.text = intent.extras?.getString("player1", "პირველი მოთამაშე")
        name2.text = intent.extras?.getString("player2", "მეორე მოთამაშე")
        name3.text = intent.extras?.getString("player3", "მესამე მოთამაშე")
        name4.text = intent.extras?.getString("player4", "მეოთხე მოთამაშე")
        result1.text = intent.extras?.getString("result1", "")
        result2.text = intent.extras?.getString("result2", "")
        result3.text = intent.extras?.getString("result3", "")
        result4.text = intent.extras?.getString("result4", "")

        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}