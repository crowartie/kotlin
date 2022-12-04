package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var minValue: EditText
    lateinit var maxValue: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        minValue = findViewById(R.id.minValue)
        maxValue = findViewById(R.id.maxValue)
    }
    fun alert(alertMessage: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialogTitle)
        builder.setMessage(alertMessage)
        builder.setNeutralButton("OK") { dialogInterface, which ->
            Toast.makeText(
                applicationContext,
                "clicked OK",
                Toast.LENGTH_LONG
            ).show()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    fun onStartGameClick(view: View) {
        if((isEmpty(minValue.text)) and (isEmpty(maxValue.text))) {
            alert("Поля со значениями пустые.")
        }
        else if((isEmpty(minValue.text)) || (isEmpty(maxValue.text))){
            if (isEmpty(maxValue.text)) {
                alert("Поле для максимального значения пустое.")
            } else if (isEmpty(minValue.text)) {
                alert("Поле для минимального значения пустое.")
            }
        }
        else{
            val minValue: Int =minValue.text.toString().toInt()
            val maxValue: Int =maxValue.text.toString().toInt()
            if (minValue==maxValue){
                alert("Минимальное и максимальное значения равны.")
            }
            else if(minValue>maxValue){
                alert("Минимальное значение больше максимального.")
            }
            else{
                 val intent = Intent(this, GameActivity::class.java)
                     intent.putExtra("begin", minValue.toString())
                     intent.putExtra("end", maxValue.toString())

                startActivity(intent)
                //println("////////////////////${maxValue}")
                //println("////////////////////${minValue}")
            }
        }
    }
}