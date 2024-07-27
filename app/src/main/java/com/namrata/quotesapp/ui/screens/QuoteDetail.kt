package com.namrata.quotesapp.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.namrata.quotesapp.db.DataManager
import com.namrata.quotesapp.model.Quotes

@Composable
fun QuoteDetail(quote: Quotes) {
    BackHandler {
        DataManager.switchScreens(null)
    }
    Box (
        contentAlignment = Alignment. Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xffffffff),
                        Color(0xFFE3E3E3)
                    )
                ),
                RectangleShape,
                1f
            )
    ){
        Card (
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ),
            modifier = Modifier.padding(32.dp)){
            Column (
                verticalArrangement = Arrangement. Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding (16.dp, 24. dp)
            ){
                Image (
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(50.dp)
                )
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}