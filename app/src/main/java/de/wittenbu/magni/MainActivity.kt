package de.wittenbu.magni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import de.wittenbu.magni.ui.theme.MagniTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MagniTheme {
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
// icons to mimic drawer destinations
                val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
                val selectedItem = remember { mutableStateOf(items[0]) }
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Spacer(Modifier.height(12.dp))
                            Text(
                                text = stringResource(id = R.string.app_name),
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                modifier = Modifier.padding(start = 16.dp, end = 28.dp)


                            )
                            Spacer(Modifier.height(12.dp))
                            Divider(Modifier.padding(start = 16.dp, end = 28.dp))
                            Spacer(Modifier.height(12.dp))
                            items.forEach { item ->
                                NavigationDrawerItem(
                                    icon = { Icon(item, contentDescription = null) },
                                    label = { Text(item.name) },
                                    selected = item == selectedItem.value,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        selectedItem.value = item
                                    },
                                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                )
                            }
                        }
                    },
                    content = {
                        Scaffold(
                            topBar = {
                                AppBar(onNavigationIconClick = { scope.launch { drawerState.open() } })
                            },
                            content = { innerPadding ->
                                LazyColumn(
                                    modifier = Modifier.consumedWindowInsets(innerPadding),
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
                        )
                    }
                )
            }
        }
    }
}