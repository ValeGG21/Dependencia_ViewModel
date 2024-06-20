package com.sena.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.sena.viewmodel.Presentation.Home.HomeScreenViewModel
import com.sena.viewmodel.Presentation.Home.HomeScreen
import com.sena.viewmodel.Presentation.theme.ViewModelTheme

internal val viewModel: HomeScreenViewModel = HomeScreenViewModel()
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = calculateWindowSizeClass(this)
            ViewModelTheme(
                windowSize = windowSize.widthSizeClass
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    HomeScreen(viewModel)
                }
            }
        }
    }
}