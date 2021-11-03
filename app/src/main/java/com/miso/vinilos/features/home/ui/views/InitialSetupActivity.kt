package com.miso.vinilos.features.home.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miso.vinilos.databinding.ActivityInitialSetupBinding
import com.miso.vinilos.features.home.ui.viewModels.InitialSetupViewModel
import com.miso.vinilos.features.home.ui.viewModels.InitialSetupViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class InitialSetupActivity : AppCompatActivity() {

    private lateinit var viewModel: InitialSetupViewModel
    private lateinit var binding: ActivityInitialSetupBinding
    private val tag = "InitialSetup"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = InitialSetupViewModelFactory.getInstance()

    }
}