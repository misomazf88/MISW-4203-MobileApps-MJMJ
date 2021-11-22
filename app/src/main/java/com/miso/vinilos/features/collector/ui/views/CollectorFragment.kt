package com.miso.vinilos.features.collector.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.R
import com.miso.vinilos.databinding.CollectorFragmentBinding
import com.miso.vinilos.features.collector.ui.viewModels.CollectorViewModel
import com.miso.vinilos.features.collector.ui.viewModels.CollectorViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class CollectorFragment : Fragment() {

    companion object {
        fun newInstance() = CollectorFragment()
    }

    private lateinit var viewModel: CollectorViewModel
    private lateinit var binding: CollectorFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModelFactory = CollectorViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[CollectorViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater, R.layout.collector_fragment,container,false)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
        return binding.root
    }
}