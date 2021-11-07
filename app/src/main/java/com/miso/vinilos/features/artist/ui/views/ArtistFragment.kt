package com.miso.vinilos.features.artist.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.miso.vinilos.R
import com.miso.vinilos.core.utils.MyItemDecoration
import com.miso.vinilos.databinding.ArtistFragmentBinding
import com.miso.vinilos.features.album.ui.viewModels.AlbumViewModel
import com.miso.vinilos.features.artist.ui.viewModels.ArtistViewModel
import com.miso.vinilos.features.artist.ui.viewModels.ArtistViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

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
        binding.rvArtistas.addItemDecoration(MyItemDecoration())
        return binding.root
    }

}