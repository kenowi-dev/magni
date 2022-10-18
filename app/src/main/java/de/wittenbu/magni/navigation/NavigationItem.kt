package de.wittenbu.magni.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@Composable
fun NavigationItem(
    route: Route,
    imageVector: ImageVector,
    contentDescription: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationItem(
        route = route,
        painter = rememberVectorPainter(image = imageVector),
        contentDescription = contentDescription,
        selected = selected,
        onClick = onClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationItem(
    route: Route,
    painter: Painter,
    contentDescription: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        icon = { Icon(painter, contentDescription = contentDescription) },
        label = { Text(route.name) },
        selected = selected,
        onClick = onClick,
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}