package com.miso.vinilos.features.collector.domain.useCases

import com.miso.vinilos.features.collector.data.repository.CollectorRepository
import com.miso.vinilos.features.collector.domain.entities.Collector

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.domain.useCases
 * Created by Jhonnatan E. Zamudio P. on 21/11/2021 at 8:17 p. m.
 * All rights reserved 2021.
 ****/

class CollectorUseCase(private val collectorRepository: CollectorRepository) {

    suspend fun getCollectors(): List<Collector> {
        return collectorRepository.getCollectorsRemote()
    }

}