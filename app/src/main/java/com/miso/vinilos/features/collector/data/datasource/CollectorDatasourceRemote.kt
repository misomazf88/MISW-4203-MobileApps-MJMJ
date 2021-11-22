package com.miso.vinilos.features.collector.data.datasource

import com.miso.vinilos.core.retroft.RetrofitHelper
import com.miso.vinilos.features.collector.data.source.CollectorApiClient
import com.miso.vinilos.features.collector.domain.entities.Collector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.data.datasource
 * Created by Miguel Zapata on 21/11/2021 at 7:45 p. m.
 * All rights reserved 2021.
 ****/

class CollectorDatasourceRemote {
    private val retrofit = RetrofitHelper.getRetrofit()
    private val response = retrofit.create(CollectorApiClient::class.java)

    suspend fun getCollectors(): List<Collector>{
        return withContext(Dispatchers.IO) {
            response.getAllCollectors().body() ?: emptyList()
        }
    }
}