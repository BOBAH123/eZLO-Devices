package com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.navigation

import android.os.Bundle
import androidx.navigation.NavType
import androidx.navigation.navArgument

data class EditDetailsNavArgs(
    val deviceId: Int?,
    val isEdit: Boolean?,
) {
    constructor(arguments: Bundle?) : this(
        deviceId = arguments?.getString(deviceIdArg)?.toIntOrNull(),
        isEdit = arguments?.getString(isEditArg)?.toBoolean(),
    )

    companion object {
        const val deviceIdArg = "deviceId"
        const val isEditArg = "isEdit"

        val navArgs = listOf(
            navArgument(isEditArg) {
                type = NavType.BoolType
            },
            navArgument(deviceIdArg) {
                type = NavType.StringType
            },
        )
    }
}