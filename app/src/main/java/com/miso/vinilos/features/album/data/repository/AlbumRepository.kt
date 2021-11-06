package com.miso.vinilos.features.album.data.repository

import com.miso.vinilos.features.album.data.datasource.AlbumDatasourceRemote
import com.miso.vinilos.features.album.domain.entities.Albums

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.data.repository
 * Created by Milena Castillo on 5/11/2021 at 8:00 p. m.
 * All rights reserved 2021.
 ****/

class AlbumRepository(private val albumDatasourceRemote: AlbumDatasourceRemote) :
    AlbumRepositoryInterface {

    companion object {
        @Volatile
        private var instance: AlbumRepository? = null
        fun getInstance(albumDatasourceRemote: AlbumDatasourceRemote): AlbumRepository =
            instance ?: synchronized(this) {
                instance ?: AlbumRepository(albumDatasourceRemote)
            }
    }

    override suspend fun getAlbumsRemote(): List<Albums> {
        return albumDatasourceRemote.getAlbums()
    }

}