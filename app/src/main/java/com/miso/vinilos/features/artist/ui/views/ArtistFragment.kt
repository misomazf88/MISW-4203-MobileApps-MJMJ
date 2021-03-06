package com.miso.vinilos.features.artist.ui.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.miso.vinilos.R
import com.miso.vinilos.core.utils.MyItemDecoration
import com.miso.vinilos.databinding.ArtistFragmentBinding
import com.miso.vinilos.features.artist.ui.adapters.ArtistAdapter
import com.miso.vinilos.features.artist.ui.viewModels.ArtistViewModel
import com.miso.vinilos.features.artist.ui.viewModels.ArtistViewModelFactory
import com.miso.vinilos.features.home.ui.views.InitialSetupActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class ArtistFragment : Fragment() {

    companion object {
        fun newInstance() = ArtistFragment()
    }

    private lateinit var viewModel: ArtistViewModel
    private lateinit var binding: ArtistFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModelFactory = ArtistViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[ArtistViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater, R.layout.artist_fragment,container,false)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
        binding.rvArtistas.layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)
        binding.rvArtistas.addItemDecoration(MyItemDecoration(1))
        viewModel.artists.observe(viewLifecycleOwner, {
            viewModel.setLoading(false)
            binding.rvArtistas.adapter = ArtistAdapter(requireContext(),it)
        })
        viewModel.loading.observe(viewLifecycleOwner, {
            lifecycleScope.launch(Dispatchers.IO) {
                animationLoading(binding.imgLoading, it)
            }
        })
        binding.btnBack.setOnClickListener {
            goToInitialSetup()
        }
        return binding.root
    }

    private fun goToInitialSetup() {
        val intent = Intent(context, InitialSetupActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    private fun animationLoading(loading: ImageView, status: Boolean?) {
        val animation = if (status == true)
            R.anim.loading
        else
            R.anim.invisible
        loading.startAnimation(AnimationUtils.loadAnimation(context, animation))
    }

}