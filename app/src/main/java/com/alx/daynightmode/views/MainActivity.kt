package com.alx.daynightmode.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import com.alx.daynightmode.R
import com.alx.daynightmode.utils.InitApplication
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        if (InitApplication.instance.isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        card1.setOnClickListener {
            startActivity(Intent(this@MainActivity, ThemeActivity::class.java))
            finish()
        }

        card4.setOnClickListener {
            startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
        }

    }
}
