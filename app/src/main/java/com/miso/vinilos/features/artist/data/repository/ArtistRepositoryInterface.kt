package com.miso.vinilos.features.artist.data.repository

import com.miso.vinilos.features.artist.domain.entities.Artist

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.data.repository
 * Created by Juan Jose Chiroque on 7/11/2021 at 5:14 p. m.
 * All rights reserved 2021.
 ****/

interface ArtistRepositoryInterface{
    suspend fun  getArtistsRemote() : List<Artist>
}