package de.wittenbu.magni.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TagView(
    tags: List<String>
) {
    AnimatedVisibility(
        visible = tags.isNotEmpty(),
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Column() {
            Text(
                text = "Selected Tags",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
            )
            FlowRow(mainAxisSpacing = 10.dp) {
                tags.forEach {
                    ElevatedAssistChip(
                        onClick = { /*TODO*/ },
                        label = {
                            Text(
                                text = it,
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    )
                }

            }
            Divider(modifier = Modifier.padding(vertical = 5.dp))
        }
    }
}