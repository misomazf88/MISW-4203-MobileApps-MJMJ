package com.miso.vinilos.features.home.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.R
import com.miso.vinilos.databinding.ActivitySplashScreenBinding
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModel
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi


@DelicateCoroutinesApi
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashScreenViewModel
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Vinilos)
        super.onCreate(savedInstanceState)
        val viewModelFactory = SplashScreenViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory) [SplashScreenViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
    }
}