package com.miso.vinilos.features.album.data.datasource

import com.miso.vinilos.core.retroft.RetrofitHelper
import com.miso.vinilos.features.album.data.entities.ResponseAlbums
import com.miso.vinilos.features.album.data.source.AlbumApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.data.datasource
 * Created by Milena Castillo on 5/11/2021 at 7:45 p. m.
 * All rights reserved 2021.
 ****/

class AlbumDatasourceRemote {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val response = retrofit.create(AlbumApiClient::class.java)

    suspend fun getAlbums(): List<ResponseAlbums>{
        return withContext(Dispatchers.IO) {
            response.getAllAlbums().body() ?: emptyList()
        }
    }
}