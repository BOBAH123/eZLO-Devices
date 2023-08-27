package com.easyservice.ezlodevices.shared.data.di

import android.content.Context
import androidx.room.Room
import com.easyservice.ezlodevices.shared.data.local.DevicesDatabase
import com.easyservice.ezlodevices.shared.data.local.dao.DeviceDao
import com.easyservice.ezlodevices.shared.data.remote.api.DevicesApi
import com.easyservice.ezlodevices.shared.data.repository.DevicesRepository
import com.easyservice.ezlodevices.shared.data.repository.DevicesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun DevicesRepositoryImpl.bindDevicesRepository(): DevicesRepository

    companion object {
        private const val BASE_URL = "https://veramobile.mios.com/test_android/"
//        private const val BASE_URL = "https://veramobile.mios.com/test_android/drawable-hdpi/" // more results

        @Singleton
        @Provides
        fun provideDevicesAPI(): DevicesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(DevicesApi::class.java)
        }

        @Singleton
        @Provides
        fun provideAppDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
            context, DevicesDatabase::class.java, "database-name"
        ).build()

        @Singleton
        @Provides
        fun provideGiphyDao(appDatabase: DevicesDatabase): DeviceDao = appDatabase.deviceDao()
    }
}