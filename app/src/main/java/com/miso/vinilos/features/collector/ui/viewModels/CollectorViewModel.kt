package com.miso.vinilos.features.collector.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miso.vinilos.features.collector.data.repository.CollectorRepository
import com.miso.vinilos.features.collector.domain.entities.Collector
import com.miso.vinilos.features.collector.domain.useCases.CollectorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CollectorViewModel(collectorRepository: CollectorRepository) : ViewModel() {

    private val collectorUseCase = CollectorUseCase(collectorRepository)
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    private val _collectors = MutableLiveData<List<Collector>>()
    val collectors: LiveData<List<Collector>> = _collectors

    init {
        setLoading(true)
    }

    fun setLoading(status: Boolean) {
        _loading.value = status
    }


}