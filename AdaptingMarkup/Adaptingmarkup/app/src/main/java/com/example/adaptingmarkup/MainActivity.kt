package com.example.adaptingmarkup

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.nio.file.Files
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {
    private lateinit var nameImg: TypedArray
    private lateinit var button: Button
    private lateinit var iv:ImageView
    var num=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameImg= resources.obtainTypedArray(R.array.nameImg)
        iv = findViewById(R.id.picture)
        button=findViewById(R.id.Button)
        button.setOnClickListener{
            if(num!=nameImg.length()){

                iv.setImageResource(nameImg.getResourceId(num,1))
                num+=1
            }
            else {
                num=0
                iv.setImageResource(R.drawable.squarecat)
            }
        }
        // TODO: заменять картинку на ту, которую установили при нажатии кнопки
        // иначе будет исходная с котиком
    }


}