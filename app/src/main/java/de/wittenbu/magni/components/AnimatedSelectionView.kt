package de.wittenbu.magni.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T>AnimatedSelectionView(
    visible: Boolean,
    possibleValues: Array<T>,
    selectedValues: MutableCollection<T>,
    onClick: () -> Unit
) {
    AnimatedVisibility(visible = visible, enter = expandVertically(), exit = shrinkVertically()) {
        FlowRow(mainAxisSpacing = 8.dp) {
            possibleValues.forEach {
                val active = selectedValues.contains(it)
                FilterChip(
                    selected = active,
                    onClick = {
                        if (active) selectedValues.remove(it) else selectedValues.add(it)
                        onClick()
                    },
                    label = { Text(text = it.toString()) })
            }
        }
    }
}