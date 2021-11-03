package com.miso.vinilos.features.home.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.R
import com.miso.vinilos.core.utils.SharedPreferences
import com.miso.vinilos.databinding.ActivityInitialSetupBinding
import com.miso.vinilos.features.home.domain.models.enumerations.KeyPreferences
import com.miso.vinilos.features.home.ui.viewModels.InitialSetupViewModel
import com.miso.vinilos.features.home.ui.viewModels.InitialSetupViewModelFactory
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class InitialSetupActivity : AppCompatActivity() {

    private lateinit var viewModel: InitialSetupViewModel
    private lateinit var binding: ActivityInitialSetupBinding
    private val tag = "InitialSetup"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = InitialSetupViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[InitialSetupViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_initial_setup)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
        viewModel.typeUser.observe(this, {
            SharedPreferences().setData(this,KeyPreferences.TYPE.value,it)
            goToDashboard()
        })
    }

    private fun goToDashboard() {
        val intent = Intent(this@InitialSetupActivity, DashboardActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.left_in, R.anim.left_out)
        finish()
    }
}