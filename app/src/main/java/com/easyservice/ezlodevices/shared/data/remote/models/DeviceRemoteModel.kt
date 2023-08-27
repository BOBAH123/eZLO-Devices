package com.easyservice.ezlodevices.shared.data.remote.models

import com.easyservice.ezlodevices.shared.data.local.model.DeviceEntity
import com.easyservice.ezlodevices.shared.presentation.models.DevicePresentationModel
import com.easyservice.ezlodevices.shared.presentation.models.PlatformPresentationModel
import com.google.gson.annotations.SerializedName

data class DeviceRemoteModel(
    @SerializedName("PK_Device")
    val pKDevice: Int,
    @SerializedName("MacAddress")
    val macAddress: String,
    @SerializedName("PK_DeviceType")
    val pKDeviceType: Int,
    @SerializedName("PK_DeviceSubType")
    val pKDeviceSubType: Int,
    @SerializedName("Firmware")
    val firmware: String,
    @SerializedName("Server_Device")
    val serverDevice: String,
    @SerializedName("Server_Event")
    val serverEvent: String,
    @SerializedName("Server_Account")
    val serverAccount: String,
    @SerializedName("InternalIP")
    val internalIP: String,
    @SerializedName("LastAliveReported")
    val lastAliveReported: String,
    @SerializedName("Platform")
    val platform: String,
    @SerializedName("PK_Account")
    val pKAccount: Int
)

fun DeviceRemoteModel.toLocalModel() =
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
        platform = platform,
        pKAccount = pKAccount,
        deviceTitle = "Device don't have a title"
    )

fun String?.toPresentationModel(): PlatformPresentationModel {
    return when (this) {
        "Sercomm G450" -> PlatformPresentationModel.SERCOMM_G450
        "Sercomm G550" -> PlatformPresentationModel.SERCOMM_G550
        "MiCasaVerde VeraLite" -> PlatformPresentationModel.MICASAVERDE_VERALITE
        "Sercomm NA900" -> PlatformPresentationModel.SERCOMM_NA900
        "Sercomm NA301" -> PlatformPresentationModel.SERCOMM_NA301
        "Sercomm NA930" -> PlatformPresentationModel.SERCOMM_NA930
        else -> PlatformPresentationModel.UNKNOWN
    }
}