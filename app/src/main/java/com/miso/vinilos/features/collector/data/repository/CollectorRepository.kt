package com.miso.vinilos.features.collector.data.repository

import com.miso.vinilos.features.collector.data.datasource.CollectorDatasourceRemote
import com.miso.vinilos.features.collector.domain.entities.Collector

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.data.repository
 * Created by Miguel Zapata on 21/11/2021 at 7:50 p. m.
 * All rights reserved 2021.
 ****/

class CollectorRepository(private val collectorDatasourceRemote: CollectorDatasourceRemote) :
    CollectorRepositoryInterface {

    companion object {
        @Volatile
        private var instance: CollectorRepository? = null
        fun getInstance(collectorDatasourceRemote: CollectorDatasourceRemote): CollectorRepository =
            instance ?: synchronized(this) {
                instance ?: CollectorRepository(collectorDatasourceRemote)
            }
    }

    override suspend fun getCollectorsRemote(): List<Collector> {
        return collectorDatasourceRemote.getCollectors()
    }

}