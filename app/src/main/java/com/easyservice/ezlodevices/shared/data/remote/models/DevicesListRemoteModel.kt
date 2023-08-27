package com.easyservice.ezlodevices.shared.data.remote.models

import com.google.gson.annotations.SerializedName

data class DevicesListRemoteModel(
    @SerializedName("Devices")
    val devices: List<DeviceRemoteModel>
)
