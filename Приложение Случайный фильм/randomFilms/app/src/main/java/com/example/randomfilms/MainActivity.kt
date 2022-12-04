package com.example.randomfilms


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.randomfilmk.Movies
import com.google.gson.Gson
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    var num:Int=0
    private var movies_data: Movies? = null
    var name: TextView? = null
    var year: TextView? = null
    var rating: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies_stream = resources.openRawResource(R.raw.movies)
        val gson = Gson()
        movies_data = gson.fromJson(InputStreamReader(movies_stream), Movies::class.java)
        name = findViewById(R.id.name)
        year = findViewById(R.id.year)
        rating = findViewById(R.id.rating)
    }

    fun onNextClick(view: View) {
       if (num==movies_data?.movies?.size){
            Toast.makeText(this, "Список фильмов кончился, нажмите кнопку сброс", Toast.LENGTH_LONG).show()
       }
       else{
           name?.text=movies_data?.movies?.get(num)?.name
           year?.text=movies_data?.movies?.get(num)?.year.toString()
           rating?.text = movies_data?.movies?.get(num)?.rating.toString()
           num++
       }
    }
    fun onClearClick(view: View) {
        movies_data?.movies?.shuffle()
        name?.text = "movie"
        year?.text = "year"
        rating?.text = "rating"
        Toast.makeText(this, "Вы успешно сбросили список фильмов, можете просмотреть их заново", Toast.LENGTH_LONG).show()
        num=0
    }
}
