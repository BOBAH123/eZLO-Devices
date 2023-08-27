package com.easyservice.ezlodevices.shared.presentation.navigation

import androidx.navigation.NavController
import com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.navigation.EditDetailsNavArgs

fun NavController.navigateToEditDetailsScreen(args: EditDetailsNavArgs) {
    navigate(
        Destinations.EDIT_DETAILS.route
            .replace("{${EditDetailsNavArgs.deviceIdArg}}", args.deviceId.toString())
            .replace("{${EditDetailsNavArgs.isEditArg}}", args.isEdit.toString())
    )
}
