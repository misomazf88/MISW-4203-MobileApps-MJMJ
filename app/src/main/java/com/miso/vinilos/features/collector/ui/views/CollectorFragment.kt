package com.miso.vinilos.features.collector.ui.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miso.vinilos.R
import com.miso.vinilos.features.collector.ui.viewModels.CollectorViewModel

class CollectorFragment : Fragment() {

    companion object {
        fun newInstance() = CollectorFragment()
    }

    private lateinit var viewModel: CollectorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.collector_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollectorViewModel::class.java)
    }

}