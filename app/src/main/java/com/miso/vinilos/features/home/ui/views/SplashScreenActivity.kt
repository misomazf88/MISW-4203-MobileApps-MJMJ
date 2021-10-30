package com.miso.vinilos.features.home.ui.views

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.miso.vinilos.R
import com.miso.vinilos.core.models.enumerations.TypeSnackBar
import com.miso.vinilos.core.utils.CustomSnackBar
import com.miso.vinilos.core.utils.Network
import com.miso.vinilos.databinding.ActivitySplashScreenBinding
import com.miso.vinilos.features.home.domain.models.enumerations.CodePermissions
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModel
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModelFactory
import kotlinx.coroutines.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


@DelicateCoroutinesApi
class SplashScreenActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    private lateinit var viewModel: SplashScreenViewModel
    private lateinit var binding: ActivitySplashScreenBinding
    private val tag = "SplashScreen"

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Vinilos)
        super.onCreate(savedInstanceState)
        val viewModelFactory = SplashScreenViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[SplashScreenViewModel::class.java]
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
        viewModel.validateConnection.observe(this, {
            if (Network().isOnline(this))
                gotoActivity(Intent(this@SplashScreenActivity, InitialSetupActivity::class.java))
            else {
                viewModel.setLoading(false)
                viewModel.setMessageSnackBar(getString(R.string.without_connection))
            }
        })
        viewModel.messageSnackBar.observe(this, {
            CustomSnackBar().showSnackBar(
                it,
                binding.layoutContain,
                TypeSnackBar.CLOSE_APP.code,
                this
            )
        })
        viewModel.requestPermission.observe(this, {
            EasyPermissions.requestPermissions(
                this,
                viewModel.permission.value!!.message,
                viewModel.permission.value!!.code,
                viewModel.permission.value!!.type
            )
        })
    }

    private fun gotoActivity(activity: Intent) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                delay(800)
                withContext(Dispatchers.Main) {
                    viewModel.setLoading(false)
                }
                val intent = activity
                startActivity(intent)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                finish()
            }
        }
    }

    private fun animationLoading(loading: ImageView, status: Boolean?) {
        val animation = if (status == true)
            R.anim.loading
        else
            R.anim.invisible
        loading.startAnimation(AnimationUtils.loadAnimation(this, animation))
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        Log.d(
            tag,
            getString(R.string.on_permissions_granted) + requestCode + getString(R.string.double_point) + perms.size
        )
        when (requestCode) {
            CodePermissions.WRITE_STORAGE.code -> viewModel.hasPermission(
                this,
                Manifest.permission.CAMERA
            )
            CodePermissions.CAMERA.code -> viewModel.setValidateConnection(true)
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Log.d(
            tag,
            getString(R.string.permission_denied) + requestCode + getString(R.string.double_point) + perms.size
        )
        viewModel.setLoading(false)
        viewModel.setMessageSnackBar(getString(R.string.permissions_denied))
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms))
            AppSettingsDialog.Builder(this).build().show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

}