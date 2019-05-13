package com.alx.daynightmode.views

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.alx.daynightmode.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val manager = packageManager
        val info: PackageInfo
        info = manager.getPackageInfo(this.packageName, 0)
        txtVersion.text = "V "+ info.versionName

        //4 segundos - splash time
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        },3000)
    }
}
