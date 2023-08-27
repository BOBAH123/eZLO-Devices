package com.easyservice.ezlodevices.shared.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.navigation.EditDetailsNavArgs
import com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.navigation.editDetailsRouteNavigation
import com.easyservice.ezlodevices.homescreen.presentation.ui.navigation.mainRouteNavigation

@Composable
fun MainNavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HOME.route
    ) {
        mainRouteNavigation(
            rootRoute = Destinations.HOME.route,
            goToDeviceDetails = { deviceId ->
                navController.navigateToEditDetailsScreen(
                    EditDetailsNavArgs(
                        deviceId = deviceId,
                        isEdit = false
                    )
                )
            },
            goToEditDeviceDetails = { deviceId ->
                navController.navigateToEditDetailsScreen(
                    EditDetailsNavArgs(
                        deviceId = deviceId,
                        isEdit = true
                    )
                )
            },
        )
        editDetailsRouteNavigation(
            rootRoute = Destinations.EDIT_DETAILS.route,
            navigateBack = { navController.navigate(Destinations.HOME.route) }
        )
    }
}