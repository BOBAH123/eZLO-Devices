package com.easyservice.ezlodevices.homescreen.presentation.ui.route

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.easyservice.ezlodevices.R
import com.easyservice.ezlodevices.homescreen.presentation.ui.viewmodel.MainScreenViewModel
import com.easyservice.ezlodevices.shared.presentation.ui.components.AppHeader
import com.easyservice.ezlodevices.shared.presentation.ui.theme.EZLODevicesTheme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    goToDeviceDetails: (deviceId: Int) -> Unit,
    goToEditDeviceDetails: (deviceId: Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = viewModel::refetchList) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_refresh),
                contentDescription = "Refresh list"
            )
        }
    }) {
        if (uiState.isDialogShown) {
            Dialog(onDismissRequest = { viewModel.showDialog(false, null) }) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .clip(RoundedCornerShape(16.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Do you want to Edit/Delete device?")
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        onClick = {
                            uiState.selectedDeviceId?.let(goToEditDeviceDetails)
                            viewModel.showDialog(false, null)
                        }
                    ) {
                        Text(text = "Edit")
                    }
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                        onClick = viewModel::deleteDevice
                    ) {
                        Text(text = "Delete")
                    }
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        onClick = { viewModel.showDialog(false, null) }
                    ) {
                        Text(text = "Close")
                    }
                }
            }
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)) {
            AppHeader()
            LazyColumn {
                items(uiState.devices) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp)
                            .combinedClickable(
                                onClick = { goToDeviceDetails(it.pKDevice) },
                                onLongClick = { viewModel.showDialog(true, it.pKDevice) }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = it.platform.imageRes),
                            contentDescription = ""
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text(
                                text = it.deviceTitle ?: "",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = "SN: ${it.pKDevice}")
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            modifier = Modifier.size(50.dp),
                            imageVector = ImageVector.vectorResource(R.drawable.ic_arow_right),
                            contentDescription = "",
                            tint = Color.Gray
                        )
                    }

                    Divider()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    EZLODevicesTheme {
//        MainScreen(
//
//        )
    }
}