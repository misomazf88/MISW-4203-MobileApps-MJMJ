package com.miso.vinilos.features.collector.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso.vinilos.features.collector.data.repository.CollectorRepository
import com.miso.vinilos.features.collector.domain.entities.Collector
import com.miso.vinilos.features.collector.domain.useCases.CollectorUseCase
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class CollectorViewModel(collectorRepository: CollectorRepository) : ViewModel() {

    private val collectorUseCase = CollectorUseCase(collectorRepository)
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    private val _collectors = MutableLiveData<List<Collector>>()
    val collectors: LiveData<List<Collector>> = _collectors

    init {
        setLoading(true)
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                getCollectors()
            }
        }
    }

    private fun getCollectors() {
        viewModelScope.launch {
            setCollectors(collectorUseCase.getCollectors())
        }
    }

    private fun setCollectors(collectors: List<Collector>) {
        _collectors.value = collectors
    }

    fun setLoading(status: Boolean) {
        _loading.value = status
    }


}