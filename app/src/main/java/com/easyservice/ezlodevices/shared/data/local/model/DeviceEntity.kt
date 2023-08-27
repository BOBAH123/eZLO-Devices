package com.easyservice.ezlodevices.shared.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyservice.ezlodevices.shared.data.remote.models.toPresentationModel
import com.easyservice.ezlodevices.shared.presentation.models.DevicePresentationModel

@Entity(tableName = "devices")
data class DeviceEntity(
    @PrimaryKey
    @ColumnInfo(name = "pKDevice")
    val pKDevice: Int,
    @ColumnInfo(name = "macAddress")
    val macAddress: String,
    @ColumnInfo(name = "pKDeviceType")
    val pKDeviceType: Int,
    @ColumnInfo(name = "pKDeviceSubType")
    val pKDeviceSubType: Int,
    @ColumnInfo(name = "firmware")
    val firmware: String,
    @ColumnInfo(name = "serverDevice")
    val serverDevice: String,
    @ColumnInfo(name = "serverEvent")
    val serverEvent: String,
    @ColumnInfo(name = "serverAccount")
    val serverAccount: String,
    @ColumnInfo(name = "internalIP")
    val internalIP: String,
    @ColumnInfo(name = "lastAliveReported")
    val lastAliveReported: String,
    @ColumnInfo(name = "platform")
    val platform: String,
    @ColumnInfo(name = "pKAccount")
    val pKAccount: Int,
    @ColumnInfo(name = "deviceTitle")
    val deviceTitle: String?
)

fun DeviceEntity.toPresentationModel() =
    DevicePresentationModel(
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
        platform = platform.toPresentationModel(),
        pKAccount = pKAccount,
        deviceTitle = deviceTitle
    )