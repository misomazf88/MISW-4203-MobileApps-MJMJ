package com.miso.vinilos.features.album.data.repository

import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.album.domain.entities.RequestAlbum

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.data.repository
 * Created by Milena Castillo on 5/11/2021 at 8:01 p. m.
 * All rights reserved 2021.
 ****/

interface AlbumRepositoryInterface {

    suspend fun  getAlbumsRemote() : List<Album>

    suspend fun getAlbumByIdRemote(id: String): Album

    suspend fun insertAlbumRemote(requestAlbum: RequestAlbum): Album

}