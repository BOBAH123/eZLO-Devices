package com.easyservice.ezlodevices.shared.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.easyservice.ezlodevices.shared.data.local.model.DeviceEntity

@Dao
interface DeviceDao {
    @Query("SELECT * FROM devices ORDER BY pKDevice ASC")
    fun getDeviceList(): List<DeviceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<DeviceEntity>)

    @Query("SELECT * FROM devices WHERE pKDevice = :pKDevice")
    suspend fun getDeviceByPK(pKDevice: Int): DeviceEntity

    @Query("DELETE FROM devices WHERE pKDevice=:pKDevice")
    suspend fun deleteDeviceByPK(pKDevice: Int)

    @Update
    suspend fun updateDevice(device: DeviceEntity)
}