package com.miso.vinilos.features.collector.data.repository

import com.miso.vinilos.features.collector.domain.entities.Collector

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.data.repository
 * Created by Miguel Zapata on 21/11/2021 at 7:48 p. m.
 * All rights reserved 2021.
 ****/

interface CollectorRepositoryInterface {
    suspend fun  getCollectorsRemote() : List<Collector>
}