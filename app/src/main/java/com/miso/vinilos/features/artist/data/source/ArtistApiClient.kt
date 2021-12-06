package com.miso.vinilos.features.artist.data.source

import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.artist.domain.entities.RequestArtist
import retrofit2.Response
import retrofit2.http.*

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.data.source
 * Created by Juan Jose Chiroque on 7/11/2021 at 4:39 p. m.
 * All rights reserved 2021.
 ****/

interface ArtistApiClient {

    @GET("musicians")
    suspend fun getAllArtists(): Response<List<Artist>>

    @GET("musicians/{id}")
    suspend fun getArtistById(@Path("id") id: String): Response<Artist>

    @Headers("Content-Type: application/json")
    @POST("musicians")
    suspend fun insertArtist(@Body requestArtist: RequestArtist): Response<Artist>

    @POST("musicians/{idArtist}/albums/{idAlbum}")
    suspend fun addAlbumtoArtist(
        @Path("idArtist") idArtist: String,
        @Path("idAlbum") idAlbum: String
    ): Response<Album>

}