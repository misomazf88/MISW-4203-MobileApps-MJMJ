package com.miso.vinilos.features.home.ui.views

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.miso.vinilos.R
import com.miso.vinilos.databinding.ActivitySplashScreenBinding
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModel
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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
        viewModel.loading.observe(this, {
            lifecycleScope.launch(Dispatchers.IO) {
                animationLoading(binding.imageViewLoading, it)
            }
        })
        viewModel.validatePermissions.observe(this, {
            if (it.equals(true))
                viewModel.hasPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        })
    }

    private fun animationLoading(loading: ImageView, status: Boolean?) {
        val animation = if (status == true)
            R.anim.loading
        else
            R.anim.invisible
        loading.startAnimation(AnimationUtils.loadAnimation(this, animation))
    }

}