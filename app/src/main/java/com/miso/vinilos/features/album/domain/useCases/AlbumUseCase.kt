package com.miso.vinilos.features.album.domain.useCases

import com.miso.vinilos.features.album.data.repository.AlbumRepository
import com.miso.vinilos.features.album.domain.entities.Albums

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.domain.useCases
 * Created by Miguel Zapata on 5/11/2021 at 9:06 p. m.
 * All rights reserved 2021.
 ****/

class AlbumUseCase(private val albumRepository: AlbumRepository) {

    suspend fun getAlbums(): List<Albums> {
        return albumRepository.getAlbumsRemote()
    }

}