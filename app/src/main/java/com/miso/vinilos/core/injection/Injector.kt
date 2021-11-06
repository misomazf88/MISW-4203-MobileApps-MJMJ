package com.miso.vinilos.core.injection

import android.content.Context
import com.miso.vinilos.features.album.data.datasource.AlbumDatasourceRemote
import com.miso.vinilos.features.album.data.repository.AlbumRepository

/****
 * Project: vinilos
 * From: com.miso.vinilos.core.injection
 * Created by Milena Castillo on 5/11/2021 at 8:18 p. m.
 * All rights reserved 2021.
 ****/

object Injector {

    fun providerAlbumRepository() : AlbumRepository {
        val albumDatasourceRemote = AlbumDatasourceRemote()
        return AlbumRepository.getInstance(albumDatasourceRemote)
    }

}