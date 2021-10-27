package com.miso.vinilos.features.home.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miso.vinilos.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Vinilos)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}