package com.namrata.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.namrata.quotesapp.ui.theme.QuotesAppTheme
import com.namrata.quotesapp.db.DataManager
import com.namrata.quotesapp.ui.screens.QuoteDetail
import com.namrata.quotesapp.ui.screens.QuoteList
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch{
            DataManager.loadAssetsFromFile(applicationContext)
        }
        enableEdgeToEdge()
        setContent {
            QuotesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(paddingValues=innerPadding)
                }
            }
        }
    }
}

@Composable
fun App(paddingValues: PaddingValues) {
    if (DataManager.isDataLoaded.value){
        if(DataManager.currentScreen.value==Screens.LISTING){
            QuoteList(paddingValues,data = DataManager.data) {
                DataManager.switchScreens(it)
            }
        }else{
            DataManager.currentQuote?.let {
                QuoteDetail(quote =it)
            }

        }

    }else{
        CircularProgressIndicator()
    }
}

enum class Screens{
    LISTING,
    DETAILS
}
