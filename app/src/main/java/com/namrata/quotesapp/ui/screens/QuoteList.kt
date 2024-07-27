package com.namrata.quotesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.namrata.quotesapp.model.Quotes

@Composable
fun QuoteList(paddingValues: PaddingValues,data:Array<Quotes>,onClick:(quote:Quotes)->Unit) {
    Column (Modifier.padding(paddingValues)){
        Text("Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp,24.dp)
                .fillMaxWidth(1f),
            )
        LazyColumn {
            items(data){quote->
                QuoteListItem(quote = quote, onClick = onClick)
            }
        }
    }

}