package com.miso.vinilos.features.collector.ui.views

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.miso.vinilos.R
import com.miso.vinilos.core.utils.MyItemDecoration
import com.miso.vinilos.core.utils.SharedPreferences
import com.miso.vinilos.databinding.CollectorFragmentBinding
import com.miso.vinilos.features.album.ui.views.CreateAlbumActivity
import com.miso.vinilos.features.collector.ui.adapters.CollectorAdapter
import com.miso.vinilos.features.collector.ui.viewModels.CollectorViewModel
import com.miso.vinilos.features.collector.ui.viewModels.CollectorViewModelFactory
import com.miso.vinilos.features.home.domain.models.enumerations.KeyPreferences
import com.miso.vinilos.features.home.domain.models.enumerations.TypeUser
import com.miso.vinilos.features.home.ui.views.InitialSetupActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        binding.rvCollectors.layoutManager = LinearLayoutManager(context)
        binding.rvCollectors.addItemDecoration(MyItemDecoration(2))
        getTypeUser()
        viewModel.loading.observe(viewLifecycleOwner, {
            lifecycleScope.launch(Dispatchers.IO) {
                animationLoading(binding.imgLoading, it)
            }
        })
        viewModel.collectors.observe(viewLifecycleOwner, {
            viewModel.setLoading(false)
            binding.rvCollectors.adapter = CollectorAdapter(requireContext(),it)
        })
        binding.btnBack.setOnClickListener {
            goToInitialSetup()
        }
        binding.btnCreate.setOnClickListener {
            gotoActivity(1)
        }
        binding.btnAssociate.setOnClickListener {
            gotoActivity(2)
        }
        return binding.root
    }

    private fun gotoActivity(activity: Int) {
        var intent = Intent()
        if (activity == 1)
            intent = Intent(context, CreateAlbumActivity::class.java)
        else if (activity == 2)
            intent = Intent(context, AssociateTrackActivity::class.java)
        startActivity(intent)
    }

    private fun goToInitialSetup() {
        val intent = Intent(context, InitialSetupActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    private fun getTypeUser() {
        val typeUser = SharedPreferences().getData(requireContext(),KeyPreferences.TYPE.value)
        if (typeUser != TypeUser.COLLECTOR.value) {
            binding.btnAssociate.visibility = View.GONE
            binding.btnCreate.visibility = View.GONE
        }
    }

    private fun animationLoading(loading: ImageView, status: Boolean?) {
        val animation = if (status == true)
            R.anim.loading
        else
            R.anim.invisible
        loading.startAnimation(AnimationUtils.loadAnimation(context, animation))
    }
}