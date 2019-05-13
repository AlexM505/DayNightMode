package com.alx.daynightmode.utils

import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.os.Build
import android.provider.Settings
import android.support.annotation.RequiresApi

class SystemUtils{

    companion object {
        private var instance: SystemUtils? = null

        val systemInstance: SystemUtils
            get() {
                if (instance == null) {
                    instance = SystemUtils()
                }

                return instance!!
            }
    }

    @SuppressLint("HardwareIds")
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun getIMEI(ctx: Context): String {
        return Settings.Secure.getString(ctx.contentResolver, Settings.Secure.ANDROID_ID)
    }

    fun isGpsOn(ctx: Context): Boolean {
        try {
            val manager = ctx.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (e: Exception) {
            return false
        }

    }

    fun checkInternetConnetivity(ctx: Context): Boolean {
        val cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        var isActive = false

        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI || activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {

                if (activeNetwork.isConnected)
                    isActive = true
            }
        }

        return isActive
    }

    fun checkTypeInternet(ctx: Context): String {
        val cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        var type = "False"

        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                type = "Conectado WI-FI"
            } else {
                if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                    type = "Conectado DatosMoviles"
                }
            }
        }

        return type
    }
}