package com.example.jokerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        var isMoshla = false
        var isGaormageba = false

        moshla.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                moshla.setBackgroundColor(resources.getColor(R.color.green))
                isMoshla = true
            }else{
                moshla.setBackgroundColor(resources.getColor(R.color.gray))
                isMoshla = false
            }
        }
        gaormageba.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                gaormageba.setBackgroundColor(resources.getColor(R.color.green))
                isGaormageba = true
            }else{
                gaormageba.setBackgroundColor(resources.getColor(R.color.gray))
                isGaormageba = false
            }
        }

        beginButton.setOnClickListener {
            begin(isMoshla, isGaormageba)
        }
    }


    private fun begin(moshla: Boolean, gaormageba: Boolean) {
        val name1 = player1.text.toString()
        val name2 = player2.text.toString()
        val name3 = player3.text.toString()
        val name4 = player4.text.toString()
        val xishti = xishti.text.toString()
        if(name1.isNotEmpty() && name2.isNotEmpty() && name3.isNotEmpty() && name4.isNotEmpty()){
            if(xishti.isNotEmpty()){
                if(xishti.toInt()%10 == 0) {
                    if (moshla == false && gaormageba == false) {
                        Toast.makeText(this, "პრემიაზე აირჩიეთ ერთ-ერთი ბონუსი მაინც", Toast.LENGTH_LONG).show()
                    } else {
                        val intent = Intent(this, GameActivity::class.java)
                        intent.putExtra("player1", name1)
                        intent.putExtra("player2", name2)
                        intent.putExtra("player3", name3)
                        intent.putExtra("player4", name4)
                        intent.putExtra("xishti", xishti.toInt())
                        intent.putExtra("moshla", moshla)
                        intent.putExtra("gaormageba", gaormageba)
                        startActivity(intent)
                    }
                }else{
                    Toast.makeText(this, "ხიშტი უნდა იყოს მრგვალი რიცხვი ათეული სიზუსტით", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "შეიყვანეთ ხიშტი", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "შეიყვანეთ ოთხივე მოთამაშის სახელი", Toast.LENGTH_LONG).show()
        }
    }
}