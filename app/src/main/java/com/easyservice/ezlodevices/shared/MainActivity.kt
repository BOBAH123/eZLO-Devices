package com.easyservice.ezlodevices.shared

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.easyservice.ezlodevices.shared.presentation.ui.theme.EZLODevicesTheme
import com.easyservice.ezlodevices.shared.presentation.navigation.MainNavigationComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EZLODevicesTheme {
                // A surface container using the 'background' color from the theme
                MainNavigationComponent(navController = rememberNavController())
            }
        }
    }
}