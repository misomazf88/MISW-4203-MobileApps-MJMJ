package com.miso.vinilos.features.collector.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.collector.domain.entities.Collector

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.ui.viewModels
 * Created by Milena Castillo on 4/12/2021 at 6:53 p. m.
 * All rights reserved 2021.
 ****/

class CollectorDetailViewModel: ViewModel() {
    private val _collector = MutableLiveData<Collector>()
    val collector: LiveData<Collector> = _collector

    fun setCollector(collector: Collector) {
        _collector.value = collector
    }
}