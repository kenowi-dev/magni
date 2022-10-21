package de.wittenbu.magni.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.wittenbu.magni.ui.theme.Shape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionChip(
    selected: Boolean,
    onClick: () -> Unit,
    text: String
) {
    InputChip(
        selected = selected,
        onClick = onClick,
        label = { Text(text, modifier = Modifier.offset(x = 5.dp)) },
        shape = Shape().large,
        trailingIcon = {
            Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
        }

    )
}