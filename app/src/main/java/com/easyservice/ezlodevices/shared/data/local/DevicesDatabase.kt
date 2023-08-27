package com.easyservice.ezlodevices.shared.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.easyservice.ezlodevices.shared.data.local.dao.DeviceDao
import com.easyservice.ezlodevices.shared.data.local.model.DeviceEntity

@Database(entities = [DeviceEntity::class], version = 1)
abstract class DevicesDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
}