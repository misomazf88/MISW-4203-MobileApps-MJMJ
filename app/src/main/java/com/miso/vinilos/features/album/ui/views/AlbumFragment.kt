package com.miso.vinilos.features.album.ui.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.miso.vinilos.R
import com.miso.vinilos.databinding.AlbumFragmentBinding
import com.miso.vinilos.features.album.ui.viewModels.AlbumViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.miso.vinilos.core.utils.MyItemDecoration
import com.miso.vinilos.features.album.ui.adapters.AlbumAdapter


class AlbumFragment : Fragment() {

    companion object {
        fun newInstance() = AlbumFragment()
    }

    private lateinit var viewModel: AlbumViewModel
    private lateinit var binding: AlbumFragmentBinding
    private val rvAlbumAdapter = AlbumAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.album_fragment,container,false)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
        binding.rvAlbumes.layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        binding.rvAlbumes.addItemDecoration(MyItemDecoration())
        binding.rvAlbumes.adapter = rvAlbumAdapter
        return binding.root
    }

}