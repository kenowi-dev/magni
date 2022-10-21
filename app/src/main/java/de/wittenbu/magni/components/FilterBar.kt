package de.wittenbu.magni.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import de.wittenbu.magni.ui.theme.Shape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBar(
    selectedTag:  MutableState<String?>,
    tags: List<String>,
    types: List<Pair<String, List<String>>>,
    onClearTags: () -> Unit
) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        AnimatedVisibility(
            visible = tags.isNotEmpty(),
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            ElevatedButton(onClick = onClearTags, content = { Text("Clear") })
        }

        types.forEach { type ->
            val angle: Float by animateFloatAsState(
                targetValue = if (selectedTag.value == type.first) 180f else 0f,
                animationSpec = tween(durationMillis = 300)
            )
            InputChip(
                selected = tags.any { type.second.contains(it) },
                onClick = { selectedTag.value = if (selectedTag.value != type.first) type.first else null },
                label = { Text(type.first, modifier = Modifier.offset(x = 5.dp)) },
                shape = Shape().large,
                trailingIcon = {
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.rotate(angle)
                    )
                }
            )
        }
    }
}