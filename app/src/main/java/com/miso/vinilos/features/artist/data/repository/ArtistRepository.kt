package com.miso.vinilos.features.artist.data.repository

import com.miso.vinilos.features.artist.data.datasource.ArtistDatasourceRemote
import com.miso.vinilos.features.artist.domain.entities.Artist

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.data.repository
 * Created by Juan Jose Chiroque on 7/11/2021 at 5:13 p. m.
 * All rights reserved 2021.
 ****/

class ArtistRepository (private val artistDatasourceRemote: ArtistDatasourceRemote) :
    ArtistRepositoryInterface {

    companion object {
        @Volatile
        private var instance: ArtistRepository? = null
        fun getInstance(artistDatasourceRemote: ArtistDatasourceRemote): ArtistRepository =
            instance ?: synchronized(this) {
                instance ?: ArtistRepository(artistDatasourceRemote)
            }
    }

    override suspend fun getArtistsRemote(): List<Artist> {
        return artistDatasourceRemote.getArtists()
    }

}