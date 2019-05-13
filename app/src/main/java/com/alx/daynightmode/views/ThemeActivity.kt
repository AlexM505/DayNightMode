package com.alx.daynightmode.views

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.alx.daynightmode.R
import kotlinx.android.synthetic.main.activity_theme.*
import java.lang.Exception

class ThemeActivity : AppCompatActivity() {

    private var SHARED_PREFS = "codeTheme"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)
        supportActionBar!!.hide()

        holderbg.setBackgroundResource(R.drawable.bggreen)
        holderbg.setScaleY(3f)
        holderbg.setScaleX(3f)

        btngreen.setScaleY(1.5f)
        btngreen.setScaleX(1.5f)

        // default
        val themeku = ""
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(themeku, "green")
        editor.apply()

        btnsave.setOnClickListener {
            startActivity(Intent(this@ThemeActivity, ChosenThemeActivity::class.java))
            finish()
        }

        //Botones, guardando tema seleccionado
        saveButtonPrefs()
    }

    fun saveButtonPrefs(){
        try{
            btnblue.setOnClickListener {
                // scale animation
                btnblue.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

                // default the scale buttons
                btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btnorange.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

                // cambio de background
                dynamicbg.setBackgroundResource(R.drawable.bgblue)
                dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

                // cambio colortext del boton
                btnsave.setTextColor(Color.parseColor("#3498db"))

                // guardar local storage
                val themeku = ""
                val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(themeku, "blue")
                editor.apply()

                // timer para cambiar el BG
                val handler = Handler()
                handler.postDelayed({
                    holderbg.scaleX = 3f
                    holderbg.scaleY = 3f
                    holderbg.setBackgroundResource(R.drawable.bgblue)
                    dynamicbg.scaleX = 0f
                    dynamicbg.scaleY = 0f
                }, 850)
            }


            btngreen.setOnClickListener {

                btngreen.animate().scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

                btnblue.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btnorange.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

                dynamicbg.setBackgroundResource(R.drawable.bggreen)
                dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

                btnsave.setTextColor(Color.parseColor("#1bac9c"))

                val themeku = ""
                val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(themeku, "green")
                editor.apply()

                val handler = Handler()
                handler.postDelayed({
                    holderbg.scaleX = 3f
                    holderbg.scaleY = 3f
                    holderbg.setBackgroundResource(R.drawable.bggreen)
                    dynamicbg.scaleX = 0f
                    dynamicbg.scaleY = 0f
                }, 850)
            }

            btnpurple.setOnClickListener {

                btnpurple.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

                btnblue.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btnorange.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

                dynamicbg.setBackgroundResource(R.drawable.bgpurple)
                dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

                btnsave.setTextColor(Color.parseColor("#E03FA2"))

                val themeku = ""
                val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(themeku, "purple")
                editor.apply()

                val handler = Handler()
                handler.postDelayed({
                    holderbg.scaleX = 3f
                    holderbg.scaleY = 3f
                    holderbg.setBackgroundResource(R.drawable.bgpurple)
                    dynamicbg.scaleX = 0f
                    dynamicbg.scaleY = 0f
                }, 850)
            }

            btnorange.setOnClickListener {

                btnorange.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

                btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btnblue.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
                btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

                dynamicbg.setBackgroundResource(R.drawable.bgorange)
                dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

                btnsave.setTextColor(Color.parseColor("#FF8D7E"))

                val themeku = ""
                val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(themeku, "orange")
                editor.apply()

                val handler = Handler()
                handler.postDelayed({
                    holderbg.scaleX = 3f
                    holderbg.scaleY = 3f
                    holderbg.setBackgroundResource(R.drawable.bgorange)
                    dynamicbg.scaleX = 0f
                    dynamicbg.scaleY = 0f
                }, 850)
            }
        }catch (e:Exception){
            println(">>Error en saveButtonPrefs "+e.message)
        }
    }
}
