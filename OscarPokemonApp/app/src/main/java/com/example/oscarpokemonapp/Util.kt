package com.example.oscarpokemonapp

import org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


    fun URL.UrlSetup() : String {
        //val url : URL = URL(myUrl)
        val con = this.openConnection() as HttpURLConnection
        val inStream = con.inputStream
        var res = ""
        inStream.use {
            //this will close the stream automatically after reading it
            res = IOUtils.toString(it, StandardCharsets.UTF_8)
        }
        return res
    }

    fun URL.downloadUrlAsync(callback: (result: String) -> Unit): Unit{
        thread{
            callback(this.UrlSetup())
        }
    }


