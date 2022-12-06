package com.example.arrayadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private var human: MutableList<String> = arrayListOf()
    private lateinit var womanName : Array<String>
    private lateinit var womanSurname : Array<String>
    private lateinit var manName : Array<String>
    private lateinit var manSurname : Array<String>
    private lateinit var button:Button
    private lateinit var inputNewHuman:EditText
    private lateinit var arrayAdapter:ArrayAdapter<String>
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNewHuman=findViewById(R.id.inputNewHuman)
        listView=findViewById(R.id.listview_1)
        button=findViewById(R.id.addHumanButton)
        arraysDeclaration()
        generateNameHuman()
        filling()
        addHuman()
    }
    private fun arraysDeclaration(){
        womanName = resources.getStringArray(R.array.womanName)
        womanSurname = resources.getStringArray(R.array.womanSurname)
        manName = resources.getStringArray(R.array.manName)
        manSurname = resources.getStringArray(R.array.manSurname)
        shuffling()
    }
    private fun shuffling(){
        womanName.shuffle()
        womanSurname.shuffle()
        manName.shuffle()
        manSurname.shuffle()
    }
    private fun generateNameHuman(){
        for (i in womanName.indices){
            for (j in womanSurname.indices){
                human.add(womanName[i]+" "+womanSurname[j])
            }
        }
        for (i in manName.indices){
            for (j in manSurname.indices){
                human.add(manName[i]+" "+manSurname[j])
            }
        }
        human.shuffle()
    }
    private fun filling(){
        arrayAdapter  =ArrayAdapter<String>(this, R.layout.text_view_item, human)
        listView.adapter=arrayAdapter
    }
    fun addHuman() {
        button.setOnClickListener{
            if(!isEmpty(inputNewHuman.text)){
                human.add(inputNewHuman.text.toString())
                arrayAdapter.notifyDataSetChanged()
            }
        }
    }
}