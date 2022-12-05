package com.example.flightsearch

import DatePickerFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adultTicket: EditText
    private lateinit var childTicket: EditText
    private lateinit var babyTicket: EditText
    private lateinit var countTicket: TextView
    private lateinit var DepartureCity: Spinner
    private lateinit var arrivalCity: Spinner
    lateinit var cities : Array<String>
    private var count: Int=0
    val myCalendar: Calendar = Calendar.getInstance()
    lateinit var DepartureDate : EditText
    lateinit var ArrivalDate : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cities = resources.getStringArray(R.array.cities)
        adultTicket = findViewById(R.id.adultTicket)
        childTicket = findViewById(R.id.childTicket)
        babyTicket = findViewById(R.id.babyTicket)
        countTicket=findViewById(R.id.countTicket)
        DepartureCity = findViewById(R.id.DepartureCity)
        arrivalCity=findViewById(R.id.arrivalCity)
        DepartureDate = findViewById(R.id.departureDate)
        ArrivalDate = findViewById(R.id.arrivalDate)
        setSpinner()
        inputDate()
        inputCountTicker()

    }
    fun inputDate(){
        val day :Int = myCalendar.get(Calendar.DAY_OF_MONTH)
        val month:Int = myCalendar.get(Calendar.MONTH)
        val year :Int = myCalendar.get(Calendar.YEAR)

        DepartureDate.setOnClickListener {
            showDatePickerDialog(it)
            DepartureDate.setText(day.toString() + "." + month + "." + year)
            ArrivalDate.setText((day +1).toString() + "." + month + "." + year)
        }
    }
    fun showDatePickerDialog(v: View){
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager,"datePicker")

    }
    private fun setSpinner(){
        val mArrayAdapter = ArrayAdapter<Any?>(this, R.layout.spinner_item, cities)
        mArrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        DepartureCity.adapter = mArrayAdapter
        arrivalCity.adapter = mArrayAdapter
    }
    private fun inputCountTicker(){
        adultTicket.addTextChangedListener {
            countTickets()
            countTicket.text ="    "+count.toString()+":"
        }
        childTicket.addTextChangedListener{
            countTickets()
            countTicket.text ="    "+count.toString()+":"
        }
        babyTicket.addTextChangedListener{
            countTickets()
            countTicket.text  ="    "+count.toString()+":"
        }
    }
     private fun countTickets(){
        count=0
        if (!isEmpty(adultTicket.text)){
            count+=adultTicket.text.toString().toInt()
        }
        if (!isEmpty(childTicket.text)){
            count+=childTicket.text.toString().toInt()
        }
        if (!isEmpty(babyTicket.text)){
            count+=babyTicket.text.toString().toInt()
        }
    }

    fun onClickSearch(view: View) {

    }
}