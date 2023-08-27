package com.easyservice.ezlodevices.homescreen.presentation.ui.route

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import com.easyservice.ezlodevices.R
import com.easyservice.ezlodevices.homescreen.presentation.ui.components.EditDeleteDialog
import com.easyservice.ezlodevices.homescreen.presentation.ui.components.NoDevicesPlaceholder
import com.easyservice.ezlodevices.homescreen.presentation.ui.viewmodel.MainScreenViewModel
import com.easyservice.ezlodevices.shared.presentation.ui.components.AppHeader
import com.easyservice.ezlodevices.shared.presentation.ui.theme.Typography
import com.easyservice.ezlodevices.shared.presentation.ui.theme.arrowIconHeight
import com.easyservice.ezlodevices.shared.presentation.ui.theme.spacingExtraLarge
import com.easyservice.ezlodevices.shared.presentation.ui.theme.spacingNormal

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    goToDeviceDetails: (deviceId: Int) -> Unit,
    goToEditDeviceDetails: (deviceId: Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = viewModel::refetchListFromRemote) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_refresh),
                contentDescription = "Refresh list"
            )
        }
    }) {
        if (uiState.isDialogShown) {
            EditDeleteDialog(
                onDismissDialog = { viewModel.showDialog(false, null) },
                onEditClick = {
                    uiState.selectedDeviceId?.let(goToEditDeviceDetails)
                    viewModel.showDialog(false, null)
                },
                onDeleteClick = viewModel::deleteDevice
            )
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            AppHeader()
            uiState.devices?.let { devices ->
                if (devices.isEmpty()) {
                    NoDevicesPlaceholder()
                } else {
                    LazyColumn {
                        items(devices) { device ->
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .combinedClickable(
                                        onClick = { goToDeviceDetails(device.pKDevice) },
                                        onLongClick = {
                                            viewModel.showDialog(
                                                true,
                                                device.pKDevice
                                            )
                                        }
                                    )
                                    .padding(start = spacingNormal),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = device.platform.imageRes),
                                    contentDescription = device.platform.value
                                )

                                Spacer(modifier = Modifier.width(spacingNormal))

                                Column {
                                    Text(
                                        text = device.deviceTitle.orEmpty(),
                                        style = Typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(text = "SN: ${device.pKDevice}")
                                }

                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    modifier = Modifier.size(arrowIconHeight),
                                    imageVector = ImageVector.vectorResource(R.drawable.ic_arow_right),
                                    contentDescription = stringResource(id = R.string.see_details_content_description),
                                    tint = Color.Gray
                                )
                            }

                            Divider()
                        }
                    }
                }
            }

            if (uiState.devices == null) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    CircularProgressIndicator(modifier = Modifier.padding(top = spacingExtraLarge))
                }
            }
        }
    }
}