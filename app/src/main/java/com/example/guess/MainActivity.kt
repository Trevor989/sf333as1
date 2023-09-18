package com.example.guess
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a1=findViewById<TextView>(R.id.a1)
        var a2=findViewById<TextView>(R.id.a2)
        var a3=findViewById<TextView>(R.id.a3)
        var a4=0
        var a5=1
        var a6=0
        a3.text = "Play"
        a1.setVisibility(View.INVISIBLE)
        a3.setOnClickListener() {
            if (a5==0) {
                a6+=1
                if (a1.text.toString().toInt() > a4) {
                    a2.text = "Hint: It's higter than answer"
                } else if (a1.text.toString().toInt() < a4) {
                    a2.text = "Hint: It's lower than answer"
                } else {
                    a2.text = "Hint: It's answer, you try "+a6+" time"
                    a3.text = "Play again"
                    a1.setVisibility(View.INVISIBLE)
                    a5 = 1
                    a6=0
                }
            }
            else {
                a1.setVisibility(View.VISIBLE)
                a4=(1..100).random()
                a2.text = ""
                a3.text = "Send"
                a5 = 0
            }
            a1.text=""
        }
    }
}