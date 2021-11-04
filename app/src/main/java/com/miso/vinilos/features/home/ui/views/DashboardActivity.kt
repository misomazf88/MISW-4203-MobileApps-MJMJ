package com.miso.vinilos.features.home.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.miso.vinilos.R
import com.miso.vinilos.databinding.ActivityDashboardBinding
import com.miso.vinilos.features.home.domain.models.enumerations.Navigator

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        binding.lifecycleOwner = this
        binding.bottomNav.add(MeowBottomNavigation.Model(Navigator.ALBUM.code,R.drawable.ic_album))
        binding.bottomNav.add(MeowBottomNavigation.Model(Navigator.ARTIST.code,R.drawable.ic_artist))
        binding.bottomNav.add(MeowBottomNavigation.Model(Navigator.COLLECTOR.code,R.drawable.ic_collector))

        binding.bottomNav.show(Navigator.ALBUM.code, true)
    }
}