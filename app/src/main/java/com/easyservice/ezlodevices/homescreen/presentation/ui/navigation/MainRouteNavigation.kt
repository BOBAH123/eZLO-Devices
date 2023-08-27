package com.easyservice.ezlodevices.homescreen.presentation.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.easyservice.ezlodevices.homescreen.presentation.ui.route.MainScreen

fun NavGraphBuilder.mainRouteNavigation(
    rootRoute: String,
    goToDeviceDetails: (deviceId: Int) -> Unit,
    goToEditDeviceDetails: (deviceId: Int) -> Unit,
) {
    composable(rootRoute) {
        MainScreen(
            viewModel = hiltViewModel(),
            goToDeviceDetails = goToDeviceDetails,
            goToEditDeviceDetails = goToEditDeviceDetails,
        )
    }
}