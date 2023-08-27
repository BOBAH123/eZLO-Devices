package com.easyservice.ezlodevices.shared.data.repository

import com.easyservice.ezlodevices.shared.data.local.dao.DeviceDao
import com.easyservice.ezlodevices.shared.data.local.model.DeviceEntity
import com.easyservice.ezlodevices.shared.data.local.model.toPresentationModel
import com.easyservice.ezlodevices.shared.data.remote.api.DevicesApi
import com.easyservice.ezlodevices.shared.data.remote.models.toLocalModel
import com.easyservice.ezlodevices.shared.presentation.models.DevicePresentationModel
import javax.inject.Inject

class DevicesRepositoryImpl @Inject constructor(
    private val api: DevicesApi,
    private val dao: DeviceDao,
) : DevicesRepository {
    override suspend fun getDeviceList(): List<DevicePresentationModel> {
        return dao.getDeviceList().let { list ->
            if (list.isEmpty()) {
                api.getAllDevices().devices.let { devices ->
                    val localList = devices.map { it.toLocalModel() }
                    dao.insertAll(localList)
                    localList.map {
                        it.toPresentationModel()
                    }
                }
            } else {
                list.map {
                    it.toPresentationModel()
                }
            }
        }
    }

    override suspend fun reloadDeviceListFromRemote() = api.getAllDevices().devices.let { devices ->
        val localList = devices.map { it.toLocalModel() }
        dao.insertAll(localList)
    }

    override suspend fun deleteDeviceByPK(deviceId: Int) = dao.deleteDeviceByPK(deviceId)

    override suspend fun getDeviceByPK(deviceId: Int): DevicePresentationModel = dao.getDeviceByPK(deviceId).toPresentationModel()

    override suspend fun updateDevice(device: DeviceEntity) = dao.updateDevice(device)
}