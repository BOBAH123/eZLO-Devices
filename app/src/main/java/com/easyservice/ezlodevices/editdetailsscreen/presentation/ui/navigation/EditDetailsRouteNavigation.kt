package com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.route.DetailsScreen

fun NavGraphBuilder.editDetailsRouteNavigation(
    rootRoute: String
) {
    composable(rootRoute) {
        DetailsScreen(viewModel = hiltViewModel())
    }
}