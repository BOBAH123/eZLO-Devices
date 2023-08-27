package com.easyservice.ezlodevices.shared.data.remote.api

import com.easyservice.ezlodevices.shared.data.remote.models.DevicesListRemoteModel
import retrofit2.http.GET

interface DevicesApi {
    @GET("items.test")
    suspend fun getAllDevices(): DevicesListRemoteModel
}