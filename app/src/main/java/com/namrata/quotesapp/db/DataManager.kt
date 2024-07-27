package com.namrata.quotesapp.db

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.namrata.quotesapp.Screens
import com.namrata.quotesapp.model.Quotes

object DataManager {
    var data = emptyArray<Quotes>()
    var currentQuote:Quotes?=null
    var currentScreen= mutableStateOf(Screens.LISTING)

    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quotes>::class.java)
        isDataLoaded.value=true
    }
    fun switchScreens(quotes: Quotes?){
        if(currentScreen.value==Screens.LISTING){
            currentQuote=quotes
            currentScreen.value=Screens.DETAILS
        }else{
            currentScreen.value=Screens.LISTING
        }
    }

}