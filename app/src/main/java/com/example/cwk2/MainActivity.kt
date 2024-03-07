package com.example.cwk2

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val about_button = findViewById<Button>(R.id.about)
        about_button.setOnClickListener {
            val about_page = layoutInflater.inflate(R.layout.dialog_screen,null)

            val myDialog = Dialog(this)
            myDialog.setContentView(about_page)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()


            val yes_btn = about_page.findViewById<Button>(R.id.back_loss_win)

            yes_btn.setOnClickListener{
                myDialog.dismiss()
            }

        }


        val new_game_button = findViewById<Button>(R.id.new_game)

        new_game_button.setOnClickListener{
           val Intent = Intent(this, targetActivity::class.java)
            startActivity(Intent)
        }

    }

}