package de.wittenbu.magni.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.wittenbu.magni.ui.theme.MagniTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScaffold(
    title: String,
    onOpenDrawer: () -> Unit,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Box(modifier = Modifier.padding(start = 20.dp)) { Text(text = title) } },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { innerPadding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(innerPadding)
            ) {
                Surface() {
                    content()
                }
            }
        }
    )
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = false)
@Preview(name = "Light Mode")
@Composable
fun DrawerScaffoldPreview() {
    MagniTheme {
        DrawerScaffold(title = "Preview", onOpenDrawer = { }, content = {})
    }
}