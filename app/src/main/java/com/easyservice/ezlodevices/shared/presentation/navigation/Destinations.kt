package com.easyservice.ezlodevices.shared.presentation.navigation

import com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.navigation.EditDetailsNavArgs

enum class Destinations(val route: String) {
    HOME("home"),
    EDIT_DETAILS("edit_details/{${EditDetailsNavArgs.deviceIdArg}}/{${EditDetailsNavArgs.isEditArg}}")
}