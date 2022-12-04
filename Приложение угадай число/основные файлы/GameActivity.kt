package com.example.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.properties.Delegates

class GameActivity: AppCompatActivity() {
    var begin by Delegates.notNull<Int>()
    var end by Delegates.notNull<Int>()
    var stroke:Int=0
    lateinit var value: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        begin = intent.getStringExtra("begin").toString().toInt()
        end = intent.getStringExtra("end").toString().toInt()
        value = findViewById(R.id.randomNumber)
        value.text= ((begin + end) / 2).toString()

    }
    fun alert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Победа!!!")
        builder.setMessage("Победа за компьютером!!!\n" +
                "Вы загадали число${((begin + end) / 2)}\n" +
                "Число было отгаданно за $stroke ходов")
        builder.setNeutralButton("Вернуться в главное меню") { dialogInterface, which ->
            Toast.makeText(
                applicationContext,
                "clicked OK",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()

    }
    fun valueNum(){
        if (end - begin <=1){
            value.text = begin.toString()
            alert()
        }
        else {
            value.text = ((begin + end) / 2).toString()
        }
    }
    fun onButtonMoreClick(view: View) {
        begin = (begin+end)/2
        stroke++
        valueNum()
    }
    fun onButtonLessClick(view: View) {
        end = (begin+end)/2
        stroke++
        valueNum()
    }
    fun onButtonEquallyClick(view: View) {
        alert()
    }
}