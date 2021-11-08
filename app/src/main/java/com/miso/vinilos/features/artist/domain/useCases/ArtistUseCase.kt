package com.miso.vinilos.features.artist.domain.useCases

import com.miso.vinilos.features.artist.data.repository.ArtistRepository
import com.miso.vinilos.features.artist.domain.entities.Artist

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.domain.useCases
 * Created by Miguel Zapata on 7/11/2021 at 5:50 p. m.
 * All rights reserved 2021.
 ****/

class ArtistUseCase (private val artistRepository: ArtistRepository) {

    suspend fun getArtists(): List<Artist> {
        return artistRepository.getArtistsRemote()
    }

}