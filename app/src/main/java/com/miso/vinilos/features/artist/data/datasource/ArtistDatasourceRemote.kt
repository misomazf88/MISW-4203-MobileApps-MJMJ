package com.miso.vinilos.features.artist.data.datasource

import com.miso.vinilos.core.retroft.RetrofitHelper
import com.miso.vinilos.features.artist.data.source.ArtistApiClient
import com.miso.vinilos.features.artist.domain.entities.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.data.datasource
 * Created by Juan Jose Chiroque on 7/11/2021 at 5:09 p. m.
 * All rights reserved 2021.
 ****/

class ArtistDatasourceRemote {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val response = retrofit.create(ArtistApiClient::class.java)

    suspend fun getArtists(): List<Artist>{
        return withContext(Dispatchers.IO) {
            response.getAllArtists().body() ?: emptyList()
        }
    }
}