package com.example.cwk2

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


public class New_game: AppCompatActivity() {


    var TAG:String = "New_Game"
    var black_random_number_1:Int = 0
    var black_random_number_2:Int = 0
    var black_random_number_3:Int = 0
    var black_random_number_4:Int = 0
    var black_random_number_5:Int = 0

    var red_random_number_1:Int = 0
    var red_random_number_2:Int = 0
    var red_random_number_3:Int = 0
    var red_random_number_4:Int = 0
    var red_random_number_5:Int = 0

    var black = 0
    var red = 0
    var total = 0
    var target = 101

    var clickCount = 0
    var score_button_clickCount = 0

    var humanWin = 0
    var computerWin = 0


    fun scoreUpdate(){

        black += black_random_number_1 +
                black_random_number_2 +
                black_random_number_3 +
                black_random_number_4 +
                black_random_number_5

        red += red_random_number_1 +
                red_random_number_2 +
                red_random_number_3 +
                red_random_number_4 +
                red_random_number_5

        total = target
        val computer_score =findViewById<TextView>(R.id.computer_score)
        val user_score = findViewById<TextView>(R.id.user_score)
        val total_score = findViewById<TextView>(R.id.total_score)


        computer_score.text = black.toString()
        user_score.text= red.toString()
        total_score.text = total.toString()

        val humanWins = findViewById<TextView>(R.id.humanWins)
        val computerWins = findViewById<TextView>(R.id.computerWins)



        if (red>=target && red>black){

            val win_page = layoutInflater.inflate(R.layout.win_layout,null)
            val winDialog = Dialog(this)

            winDialog.setContentView(win_page)
            winDialog.setCancelable(true)
            winDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            winDialog.show()

            val back_button = win_page.findViewById<Button>(R.id.back_loss_win)

            back_button.setOnClickListener{
                winDialog.dismiss()
            }

            black = 0
            red = 0
            computer_score.text = black.toString()
            user_score.text= red.toString()
            humanWin++
            humanWins.text = humanWin.toString()
        }

        else if(black>=target && black>red){
            val loss_page = layoutInflater.inflate(R.layout.loss_layout,null)
            val lossDialog = Dialog(this)
            lossDialog.setContentView(loss_page)

            lossDialog.setCancelable(true)
            lossDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            lossDialog.show()

            val back_button = loss_page.findViewById<Button>(R.id.back_loss_win)
            back_button.setOnClickListener{
                lossDialog.dismiss()
            }

            black = 0
            red = 0
            computer_score.text = black.toString()
            user_score.text= red.toString()
            computerWin++
            computerWins.text = computerWin.toString()

        }
        else if(black == red){
            val tie_page = layoutInflater.inflate(R.layout.tie_layout,null)
            val tieDialog = Dialog(this)

            tieDialog.setContentView(tie_page)
            tieDialog.setCancelable(true)
            tieDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            tieDialog.show()

            val back_button  = tie_page.findViewById<Button>(R.id.back_loss_win)

            back_button.setOnClickListener{
                tieDialog.dismiss()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        val throw_button = findViewById<Button>(R.id.throw_button)
        val score_button = findViewById<Button>(R.id.score_button)

        val blackDice1 = findViewById<ImageView>(R.id.black_dice_image1)
        val blackDice2 = findViewById<ImageView>(R.id.black_dice_image2)
        val blackDice3 = findViewById<ImageView>(R.id.black_dice_image3)
        val blackDice4 = findViewById<ImageView>(R.id.black_dice_image4)
        val blackDice5 = findViewById<ImageView>(R.id.black_dice_image5)

        val redDice1 = findViewById<ImageView>(R.id.red_dice_image1)
        val redDice2 = findViewById<ImageView>(R.id.red_dice_image2)
        val redDice3 = findViewById<ImageView>(R.id.red_dice_image3)
        val redDice4 = findViewById<ImageView>(R.id.red_dice_image4)
        val redDice5 = findViewById<ImageView>(R.id.red_dice_image5)


        throw_button.setOnClickListener{

            score_button_clickCount = 0
            black_random_number_1 = (1..6).random()
            black_random_number_2 = (1..6).random()
            black_random_number_3 = (1..6).random()
            black_random_number_4 = (1..6).random()
            black_random_number_5 = (1..6).random()

            red_random_number_1 = (1..6).random()
            red_random_number_2 = (1..6).random()
            red_random_number_3 = (1..6).random()
            red_random_number_4 = (1..6).random()
            red_random_number_5 = (1..6).random()


            when (black_random_number_1){
                1 -> { blackDice1.setImageResource(R.drawable.black_die_1) }
                2 -> { blackDice1.setImageResource(R.drawable.black_die_2) }
                3 -> { blackDice1.setImageResource(R.drawable.black_die_3) }
                4 -> { blackDice1.setImageResource(R.drawable.black_die_4) }
                5 -> { blackDice1.setImageResource(R.drawable.black_die_5) }
                6 -> { blackDice1.setImageResource(R.drawable.black_die_6) }
            }
            when (black_random_number_2){
                1 -> { blackDice2.setImageResource(R.drawable.black_die_1) }
                2 -> { blackDice2.setImageResource(R.drawable.black_die_2) }
                3 -> { blackDice2.setImageResource(R.drawable.black_die_3) }
                4 -> { blackDice2.setImageResource(R.drawable.black_die_4) }
                5 -> { blackDice2.setImageResource(R.drawable.black_die_5) }
                6 -> { blackDice2.setImageResource(R.drawable.black_die_6) }
            }
            when (black_random_number_3){
                1 -> { blackDice3.setImageResource(R.drawable.black_die_1) }
                2 -> { blackDice3.setImageResource(R.drawable.black_die_2) }
                3 -> { blackDice3.setImageResource(R.drawable.black_die_3) }
                4 -> { blackDice3.setImageResource(R.drawable.black_die_4) }
                5 -> { blackDice3.setImageResource(R.drawable.black_die_5) }
                6 -> { blackDice3.setImageResource(R.drawable.black_die_6) }
            }
            when (black_random_number_4){
                1 -> { blackDice4.setImageResource(R.drawable.black_die_1) }
                2 -> { blackDice4.setImageResource(R.drawable.black_die_2) }
                3 -> { blackDice4.setImageResource(R.drawable.black_die_3) }
                4 -> { blackDice4.setImageResource(R.drawable.black_die_4) }
                5 -> { blackDice4.setImageResource(R.drawable.black_die_5) }
                6 -> { blackDice4.setImageResource(R.drawable.black_die_6) }
            }
            when (black_random_number_5){
                1 -> { blackDice5.setImageResource(R.drawable.black_die_1) }
                2 -> { blackDice5.setImageResource(R.drawable.black_die_2) }
                3 -> { blackDice5.setImageResource(R.drawable.black_die_3) }
                4 -> { blackDice5.setImageResource(R.drawable.black_die_4) }
                5 -> { blackDice5.setImageResource(R.drawable.black_die_5) }
                6 -> { blackDice5.setImageResource(R.drawable.black_die_6) }
            }

            when (red_random_number_1){
                1 -> { redDice1.setImageResource(R.drawable.red_die_1) }
                2 -> { redDice1.setImageResource(R.drawable.red_die_2) }
                3 -> { redDice1.setImageResource(R.drawable.red_die_3) }
                4 -> { redDice1.setImageResource(R.drawable.red_die_4) }
                5 -> { redDice1.setImageResource(R.drawable.red_die_5) }
                6 -> { redDice1.setImageResource(R.drawable.red_die_6) }
            }

            when (red_random_number_2){
                1 -> { redDice2.setImageResource(R.drawable.red_die_1) }
                2 -> { redDice2.setImageResource(R.drawable.red_die_2) }
                3 -> { redDice2.setImageResource(R.drawable.red_die_3) }
                4 -> { redDice2.setImageResource(R.drawable.red_die_4) }
                5 -> { redDice2.setImageResource(R.drawable.red_die_5) }
                6 -> { redDice2.setImageResource(R.drawable.red_die_6) }
            }

            when (red_random_number_3){
                1 -> { redDice3.setImageResource(R.drawable.red_die_1) }
                2 -> { redDice3.setImageResource(R.drawable.red_die_2) }
                3 -> { redDice3.setImageResource(R.drawable.red_die_3) }
                4 -> { redDice3.setImageResource(R.drawable.red_die_4) }
                5 -> { redDice3.setImageResource(R.drawable.red_die_5) }
                6 -> { redDice3.setImageResource(R.drawable.red_die_6) }
            }

            when (red_random_number_4){
                1 -> { redDice4.setImageResource(R.drawable.red_die_1) }
                2 -> { redDice4.setImageResource(R.drawable.red_die_2) }
                3 -> { redDice4.setImageResource(R.drawable.red_die_3) }
                4 -> { redDice4.setImageResource(R.drawable.red_die_4) }
                5 -> { redDice4.setImageResource(R.drawable.red_die_5) }
                6 -> { redDice4.setImageResource(R.drawable.red_die_6) }
            }

            when (red_random_number_5){
                1 -> { redDice5.setImageResource(R.drawable.red_die_1) }
                2 -> { redDice5.setImageResource(R.drawable.red_die_2) }
                3 -> { redDice5.setImageResource(R.drawable.red_die_3) }
                4 -> { redDice5.setImageResource(R.drawable.red_die_4) }
                5 -> { redDice5.setImageResource(R.drawable.red_die_5) }
                6 -> { redDice5.setImageResource(R.drawable.red_die_6) }
            }

            Log.e(TAG,black_random_number_1.toString())
            Log.e(TAG,black_random_number_2.toString())
            Log.e(TAG,black_random_number_3.toString())
            Log.e(TAG,black_random_number_4.toString())
            Log.e(TAG,black_random_number_5.toString())
                
            Log.e(TAG,red_random_number_1.toString())
            Log.e(TAG,red_random_number_2.toString())
            Log.e(TAG,red_random_number_3.toString())
            Log.e(TAG,red_random_number_4.toString())
            Log.e(TAG,red_random_number_5.toString())

            clickCount++

            if(clickCount==3){
                scoreUpdate()
                clickCount = 0
                score_button_clickCount=2
            }
        }

        score_button.setOnClickListener {
            score_button_clickCount++

            if(score_button_clickCount==1){
                scoreUpdate()

                if (score_button.isPressed) {
                    clickCount = 0
                }
            }
       }
    }
}







