package com.easyservice.ezlodevices.homescreen.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easyservice.ezlodevices.shared.data.repository.DevicesRepository
import com.easyservice.ezlodevices.shared.presentation.models.DevicePresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: DevicesRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        MainScreenViewModelState(
            devices = emptyList(),
            isDialogShown = false,
            selectedDeviceId = null
        )
    )
    val uiState: StateFlow<MainScreenViewModelState> = _uiState

    init {
        fetchAllDevices()
    }

    private fun fetchAllDevices() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { uiState ->
                uiState.copy(devices = repository.getDeviceList())
            }
        }
    }

    fun refetchList() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { uiState ->
                uiState.copy(devices = emptyList())
            }
            repository.reloadDeviceListFromRemote()
            fetchAllDevices()
        }
    }

    fun showDialog(showDialog: Boolean, deviceId: Int?) {
        _uiState.update { uiState ->
            uiState.copy(isDialogShown = showDialog, selectedDeviceId = deviceId)
        }
    }

    fun deleteDevice() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value.selectedDeviceId?.let { repository.deleteDeviceByPK(it) }
            fetchAllDevices()
            showDialog(false, null)
        }
    }
}

data class MainScreenViewModelState(
    val devices: List<DevicePresentationModel>,
    val isDialogShown: Boolean,
    val selectedDeviceId: Int?,
)