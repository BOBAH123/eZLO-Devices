package com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easyservice.ezlodevices.editdetailsscreen.presentation.ui.navigation.EditDetailsNavArgs
import com.easyservice.ezlodevices.shared.data.repository.DevicesRepository
import com.easyservice.ezlodevices.shared.presentation.models.DevicePresentationModel
import com.easyservice.ezlodevices.shared.presentation.models.toLocalModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditDetailsScreenViewModel @Inject constructor(
    private val repository: DevicesRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        EditDetailsScreenViewModelState(
            device = null,
            isEditMode = false
        )
    )
    val uiState: StateFlow<EditDetailsScreenViewModelState> = _uiState

    init {
        val isEditMode: String? = savedStateHandle[EditDetailsNavArgs.isEditArg]
        isEditMode?.let {
            _uiState.update { uiState ->
                uiState.copy(isEditMode = it.toBoolean())
            }
        }

        val deviceId: String? = savedStateHandle[EditDetailsNavArgs.deviceIdArg]
        deviceId?.toIntOrNull()?.let {
            fetchDeviceDetails(it)
        }
    }

    private fun fetchDeviceDetails(deviceId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { uiState ->
                uiState.copy(device = repository.getDeviceByPK(deviceId))
            }
        }
    }

    fun onValueChanged(input: String) {
        _uiState.update { uiState ->
            uiState.copy(
                device = uiState.device?.copy(
                    deviceTitle = input
                )
            )
        }
    }

    fun updateDeviceDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            uiState.value.device?.toLocalModel()?.let { repository.updateDevice(it) }
            _uiState.update { uiState ->
                uiState.copy(isEditMode = false)
            }
        }
    }
}

data class EditDetailsScreenViewModelState(
    val device: DevicePresentationModel?,
    val isEditMode: Boolean
)