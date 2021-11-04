package com.miso.vinilos.features.home.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.miso.vinilos.R
import com.miso.vinilos.databinding.ActivityDashboardBinding
import com.miso.vinilos.features.home.domain.models.enumerations.Navigator
import com.miso.vinilos.features.album.ui.views.AlbumFragment
import com.miso.vinilos.features.artist.ui.views.ArtistFragment
import com.miso.vinilos.features.collector.ui.views.CollectorFragment


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        binding.lifecycleOwner = this
        binding.bottomNav.add(MeowBottomNavigation.Model(Navigator.ALBUM.code,R.drawable.ic_album))
        binding.bottomNav.add(MeowBottomNavigation.Model(Navigator.ARTIST.code,R.drawable.ic_artist))
        binding.bottomNav.add(MeowBottomNavigation.Model(Navigator.COLLECTOR.code,R.drawable.ic_collector))
        binding.bottomNav.setOnShowListener { model: MeowBottomNavigation.Model? ->
            var select: Fragment? = null
            when (model!!.id) {
                Navigator.ALBUM.code -> select = AlbumFragment.newInstance()
                Navigator.ARTIST.code -> select = ArtistFragment.newInstance()
                Navigator.COLLECTOR.code -> select = CollectorFragment.newInstance()
            }
            assert(select != null)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, select!!)
                .commit()
        }
        binding.bottomNav.show(Navigator.ALBUM.code, true)
    }
}