package com.example.weatherdisplay

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.weatherdisplay.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var buttonSearch: Button
    lateinit var searchCity: EditText
    private var api_key:String ="7fd21e47dc11c2454d4f27cc033f607a"
        //private lateinit var weatherData:Weather
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding =DataBindingUtil.setContentView(this, R.layout.activity_main)
        searchCity=findViewById(R.id.searchCity)
            //binding.location
        buttonSearch =findViewById(R.id.search)
        buttonSearch.setOnClickListener(){
            GlobalScope.launch (Dispatchers.IO) {
                checkConn()

            }
        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun checkConn(){

        try {
            val weatherURL= "https://api.openweathermap.org/data/2.5/weather?q=" +
                    searchCity.text +
                    "&appid=" +
                    api_key
            val conn = withContext(Dispatchers.IO) {
                URL(weatherURL).openConnection()
            } as HttpURLConnection
            if(conn.responseCode == HttpURLConnection.HTTP_OK){
                loadWeather()
            }
        } catch (e: IOException) {
            false
        } catch (e: UnknownHostException){
            false
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun loadWeather(){
        val weatherURL= "https://api.openweathermap.org/data/2.5/weather?q=" +
                searchCity.text +
                "&appid=" +
                api_key
        val stream = withContext(Dispatchers.IO) {
            URL(weatherURL).content
        } as InputStream
        val data = Scanner(stream).nextLine()

        // TODO: предусмотреть обработку ошибок (нет сети, пустой ответ)


        val gson = Gson()
        val dates = gson.fromJson(data.toString(), WeatherData::class.java)
        println(dates.base)
            println(dates)
        binding.city=dates.name.toString()
        binding.location= "${dates.coord?.lat},${dates.coord?.lon}"
        binding.timezone="${dates.timezone.toString().toInt()/3600
        }"
        val sdf = SimpleDateFormat("dd/M/yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date())
        val temp:String=(dates.main?.temp.toString().toFloat()-273).toString()
        val minTemp:String=(dates.main?.tempMin.toString().toFloat()-273).toString()
        val maxTemp:String=(dates.main?.tempMax.toString().toFloat()-273).toString()
        println("${ temp }, ${ minTemp }, ${ maxTemp }")
        binding.date=currentDate
        binding.temp= temp
        binding.mintemp= minTemp
        binding.maxtemp= maxTemp
        binding.wind= dates.wind?.speed.toString()
    }


}