package com.alx.daynightmode.views

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alx.daynightmode.R
import kotlinx.android.synthetic.main.activity_chosen_theme.*

class ChosenThemeActivity : AppCompatActivity() {

    private var getThemeku: String? = null
    private var themeku = ""
    private var SHARED_PREFS = "codeTheme"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chosen_theme)
        supportActionBar!!.hide()

        changeOurTheme()

        btncontinue.setOnClickListener {
            startActivity(Intent(this@ChosenThemeActivity,MainActivity::class.java))
            finish()
        }
    }

    fun changeOurTheme() {

        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        getThemeku = sharedPreferences.getString(themeku, "")

        if (getThemeku == "blue") {
            icontheme.setImageResource(R.drawable.icmob)
            btncontinue.setBackgroundResource(R.drawable.bgblue)
            subtitlepage.setText("El agua es azul")
        } else if (getThemeku == "green") {
            icontheme.setImageResource(R.drawable.icmog)
            btncontinue.setBackgroundResource(R.drawable.bggreen)
            subtitlepage.setText("La naturaleza es verde")
        } else if (getThemeku == "purple") {
            icontheme.setImageResource(R.drawable.icmop)
            btncontinue.setBackgroundResource(R.drawable.bgpurple)
            subtitlepage.setText("La oscuridad es como purpura")
        } else if (getThemeku == "orange") {
            icontheme.setImageResource(R.drawable.icmoc)
            btncontinue.setBackgroundResource(R.drawable.bgorange)
            subtitlepage.setText("Naranja es como amarillo")
        }

    }
}
