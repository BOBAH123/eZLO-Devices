package com.easyservice.ezlodevices.shared.presentation.models

import com.easyservice.ezlodevices.shared.data.local.model.DeviceEntity

data class DevicePresentationModel(
    val pKDevice: Int,
    val macAddress: String,
    val pKDeviceType: Int,
    val pKDeviceSubType: Int,
    val firmware: String,
    val serverDevice: String,
    val serverEvent: String,
    val serverAccount: String,
    val internalIP: String,
    val lastAliveReported: String,
    val platform: PlatformPresentationModel,
    val pKAccount: Int,
    val deviceTitle: String?
)

fun DevicePresentationModel.toLocalModel() =
    DeviceEntity(
        pKDevice = pKDevice,
        macAddress = macAddress,
        pKDeviceType = pKDeviceType,
        pKDeviceSubType = pKDeviceSubType,
        firmware = firmware,
        serverDevice = serverDevice,
        serverEvent = serverEvent,
        serverAccount = serverAccount,
        internalIP = internalIP,
        lastAliveReported = lastAliveReported,
        platform = platform.value,
        pKAccount = pKAccount,
        deviceTitle = deviceTitle
    )
