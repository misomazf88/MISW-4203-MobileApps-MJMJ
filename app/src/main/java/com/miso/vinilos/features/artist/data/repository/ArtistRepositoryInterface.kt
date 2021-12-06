package com.miso.vinilos.features.artist.data.repository

import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.artist.domain.entities.RequestArtist

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.data.repository
 * Created by Juan Jose Chiroque on 7/11/2021 at 5:14 p. m.
 * All rights reserved 2021.
 ****/

interface ArtistRepositoryInterface{

    suspend fun  getArtistsRemote() : List<Artist>

    suspend fun getArtistByIdRemote(id: String): Artist

    suspend fun insertArtistRemote(requestArtist: RequestArtist): Artist

    suspend fun addAlbumtoArtistRemote(idArtist: String, idAlbum: String): Album

}