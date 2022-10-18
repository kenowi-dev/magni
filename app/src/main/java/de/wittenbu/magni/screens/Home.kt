package de.wittenbu.magni.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Home() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(count = 100) {
            val colors = listOf(
                Color(0xFFffd7d7.toInt()),
                Color(0xFFffe9d6.toInt()),
                Color(0xFFfffbd0.toInt()),
                Color(0xFFe3ffd9.toInt()),
                Color(0xFFd0fff8.toInt())
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(colors[it % colors.size])
            )
        }
    }
}