package com.example.cwk2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class targetActivity:AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.target_input_layout)


            var target_number:EditText?= findViewById<EditText>(R.id.target_number)


            val continue_button = findViewById<Button>(R.id.target_continue_button)

            continue_button.setOnClickListener{
                val Intent = Intent (this, New_game::class.java)
                startActivity(Intent)
            }



        }
}
