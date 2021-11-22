package com.miso.vinilos.features.collector.data.source

import com.miso.vinilos.features.collector.domain.entities.Collector
import retrofit2.Response
import retrofit2.http.GET

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.data.source
 * Created by Miguel Zapata on 21/11/2021 at 7:25 p. m.
 * All rights reserved 2021.
 ****/

interface CollectorApiClient {
    @GET("collectors")
    suspend fun getAllCollectors(): Response<List<Collector>>
}