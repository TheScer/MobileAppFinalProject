package com.example.oscarpokemonapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oscarpokemonapp.SecondActivity as SecondActivity1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b : Button = findViewById(R.id.button)
        //the R used above is the resource class, so whenever using shit from the XML formatting need to use that class
        val t : TextView = findViewById(R.id.search_bar)

        t.setOnClickListener(){
            t.text = ""
            //PLACEHOLDER CHANGES THE VALUE IN THE TEXT BOX WHEN CLICKING THE BUTTON
        }

        b.setOnClickListener(){
            this.buttonClicked(b)
        }
    }

    private fun buttonClicked(button: View) {
        //function to be called after clicking the search button,
        //probably needs to change the activity or re-create the page to show

        val intent = Intent(this, SecondActivity1::class.java)

        intent.putExtra("name","userinput")//can add values to next activity
        //this should be used to keep the same pokemon name in the second activity search bar

        startActivity(intent)
        //intent is used to open other activities or even use other applications
    }
}