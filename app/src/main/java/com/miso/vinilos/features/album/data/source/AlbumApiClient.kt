package com.miso.vinilos.features.album.data.source

import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.album.domain.entities.RequestAlbum
import retrofit2.Response
import retrofit2.http.*

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.data.source
 * Created by Milena Castillo on 5/11/2021 at 7:43 a. m.
 * All rights reserved 2021.
 ****/

interface AlbumApiClient {

    @GET("albums")
    suspend fun getAllAlbums(): Response<List<Album>>

    @GET("albums/{id}")
    suspend fun getAlbumById(@Path("id") id: String): Response<Album>

    @Headers("Content-Type: application/json")
    @POST("albums")
    suspend fun insertAlbum(@Body requestAlbum: RequestAlbum): Response<Album>

}