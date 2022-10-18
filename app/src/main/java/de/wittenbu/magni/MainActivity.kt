package de.wittenbu.magni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import de.wittenbu.magni.components.LayoutNavHost
import de.wittenbu.magni.ui.theme.MagniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MagniTheme {
                LayoutNavHost()
            }
        }
    }
}