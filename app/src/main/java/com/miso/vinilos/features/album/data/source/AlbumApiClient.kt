package com.miso.vinilos.features.album.data.source

import com.miso.vinilos.features.album.data.entities.ResponseAlbums
import retrofit2.Response
import retrofit2.http.GET

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.data.source
 * Created by Milena Castillo on 5/11/2021 at 7:43 a. m.
 * All rights reserved 2021.
 ****/

interface AlbumApiClient {
    @GET("albums")
    suspend fun getAllAlbums(): Response<List<ResponseAlbums>>
}