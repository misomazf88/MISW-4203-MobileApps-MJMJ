package com.miso.vinilos.features.collector.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.core.injection.Injector
import com.miso.vinilos.features.collector.data.repository.CollectorRepository
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.ui.viewModels
 * Created by Juan Chiroque on 21/11/2021 at 8:00 p. m.
 * All rights reserved 2021.
 ****/

@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class CollectorViewModelFactory(private val collectorRepository: CollectorRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: CollectorViewModelFactory? = null
        fun getInstance() : CollectorViewModelFactory = instance ?: synchronized(this) {
            instance ?: CollectorViewModelFactory(Injector.providerCollectorRepository())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CollectorViewModel(collectorRepository) as T
    }
}