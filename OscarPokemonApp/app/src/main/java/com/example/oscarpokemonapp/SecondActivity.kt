package com.example.oscarpokemonapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.io.IOUtils
import kotlin.concurrent.thread
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

//NOTE this second activity should show pokemon that match the user search but still have the search bar
//so they're able to search for another pokemon after

class SecondActivity : AppCompatActivity() {
    lateinit var textBox : EditText
    lateinit var container : LinearLayout
    lateinit var scroll : HorizontalScrollView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        this.textBox = findViewById(R.id.search_bar)
        this.container = findViewById(R.id.container)
        this.scroll = findViewById(R.id.scrollView)

        val b : Button = findViewById(R.id.button)
        //the R used above is the resource class, so whenever using shit from the XML formatting need to use that class
        val t : TextView = findViewById(R.id.search_bar)
        val name = intent.getStringExtra("name")
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()

        t.setOnClickListener(){
            thread(){
                var searchText = "name"
                while(searchText!=t.text.toString()){
                    searchText = t.text.toString()
                    Log.d("TAG", "search = $searchText")
                    Thread.sleep(1000)
                    //DO NOT DO USER INTERFACE MANIPULATION USING THE THREAD
                }
            }
            //Ideally, this has a thread that updates the search every second, or
            //whenever the input changes. Threads are used to run code at the same time as all
            //other code. currently its just a basic onclick listener
        }

        b.setOnClickListener(){
            this.searchButton(b)
        }
    }
/*
    fun UrlSetup(myUrl: String) : String {
        val url : URL = URL(myUrl)
        val con = url.openConnection() as HttpURLConnection
        val inStream = con.inputStream
        var res = ""
        inStream.use{
            //this will close the stream automatically after reading it
            res = IOUtils.toString(it, StandardCharsets.UTF_8)
        }
        return res

    }
*/
    fun searchButton(button: View) {
        //function to be called after clicking the search button,
        //probably needs to change the activity or re-create the page to show

        //1.makes http connection to a url
        val url = "https://pokeapi.co/api/v2/pokemon/${"charmander"}/"

        val myUrl = URL(url)
        URL(url).downloadUrlAsync() {
            //println(it)

            //2.needs to do some JSON parsing
            val mp = ObjectMapper()
            val result: Image = mp.readValue(it, Image::class.java)
            println(result.sprites?.front_default)
        }
        //2.needs to do some JSON parsing

        //3.then needs to update the UI and put the image of the pokemon and data on the pokemon

    }
}