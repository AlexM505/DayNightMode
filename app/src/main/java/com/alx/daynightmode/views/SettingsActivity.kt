package com.alx.daynightmode.views

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.widget.Toast
import com.alx.daynightmode.R
import com.alx.daynightmode.utils.InitApplication
import com.alx.daynightmode.utils.SystemUtils
import kotlinx.android.synthetic.main.activity_settings.*
import java.lang.Exception

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (InitApplication.instance.isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        setContentView(R.layout.activity_settings)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            switchCompat.isChecked = true

        switchCompat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                InitApplication.instance.setIsNightModeEnabled(true)
                val intent = intent
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                finish()
                startActivity(intent)

            } else {
                InitApplication.instance.setIsNightModeEnabled(false)
                val intent = intent
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                finish()
                startActivity(intent)
            }
        }

        //Botones
        buttonImei()
        buttonConection()
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun buttonImei(){
        try {
            btnImei.setOnClickListener {
                Toast.makeText(this, "Imei: "+SystemUtils.systemInstance.getIMEI(this), Toast.LENGTH_LONG).show()
            }
        }catch (e:Exception){
            println(">>Error en buttonImei: "+e.message)
        }
    }

    fun buttonConection(){
        try{
            btnConection.setOnClickListener {
                if(SystemUtils.systemInstance.checkInternetConnetivity(this))
                    Toast.makeText(this, SystemUtils.systemInstance.checkTypeInternet(this),Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this, "No hay conexion a una red", Toast.LENGTH_LONG).show()
            }
        }catch (e:Exception){
            println(">>Error en buttonConection: "+e.message)
        }
    }
}
