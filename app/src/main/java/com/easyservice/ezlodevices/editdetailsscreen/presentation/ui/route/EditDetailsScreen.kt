package com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.viewmodel.EditDetailsScreenViewModel
import com.easyservice.ezlodevices.shared.presentation.ui.components.AppHeader
import com.easyservice.ezlodevices.shared.presentation.ui.theme.Typography
import com.easyservice.ezlodevices.shared.presentation.ui.theme.spacingBig
import com.easyservice.ezlodevices.shared.presentation.ui.theme.spacingNormal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDetailsScreen(
    viewModel: EditDetailsScreenViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(Modifier.fillMaxSize()) {
        AppHeader()
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = spacingBig)
        ) {
            uiState.device?.let { device ->
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = device.platform.imageRes),
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.width(spacingNormal))

                    if (uiState.isEditMode) {
                        TextField(
                            value = device.deviceTitle.orEmpty(),
                            onValueChange = viewModel::onValueChanged
                        )
                    } else {
                        Text(
                            text = device.deviceTitle.orEmpty(),
                            style = Typography.titleLarge
                        )
                    }
                }

                if (uiState.isEditMode) {
                    Button(onClick = viewModel::updateDeviceDetails) {
                        Text(text = "Save changes")
                    }
                }

                Spacer(modifier = Modifier.height(spacingNormal))

                Text(
                    text = "SN: ${device.pKDevice}",
                    style = Typography.titleMedium,
                    color = Color.Gray
                )

                Text(
                    text = "MAC Address: ${device.macAddress}",
                    style = Typography.titleMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(spacingNormal))

                Text(
                    text = "Firmware: ${device.firmware}",
                    style = Typography.titleMedium,
                    color = Color.Gray
                )

                Text(
                    text = "Model: ${device.platform.value}",
                    style = Typography.titleMedium,
                    color = Color.Gray
                )
            }
        }
    }
}