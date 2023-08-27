package com.easyservice.ezlodevices.shared.data.repository

import com.easyservice.ezlodevices.shared.data.local.model.DeviceEntity
import com.easyservice.ezlodevices.shared.presentation.models.DevicePresentationModel

interface DevicesRepository {
    suspend fun getDeviceList(): List<DevicePresentationModel>
    suspend fun reloadDeviceListFromRemote()
    suspend fun deleteDeviceByPK(deviceId: Int)
    suspend fun getDeviceByPK(deviceId: Int): DevicePresentationModel
    suspend fun updateDevice(device: DeviceEntity)
}