package de.wittenbu.magni.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = { Box(modifier = Modifier.padding(start = 20.dp)) { Text(text = title) } },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Toggle drawer")
            }
        }
    )
}
