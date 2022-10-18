package de.wittenbu.magni.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsLayout() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Box(modifier = Modifier.padding(start = 20.dp)) { Text(text = "title") } },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go Back")
                    }
                }
            )
        },
        content = { innerPadding ->
            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(innerPadding)) {
                Text(text = "Details")
            }
        }
    )

}