package com.miso.vinilos.features.artist.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miso.vinilos.features.artist.domain.entities.Artist

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.ui.viewModels
 * Created by Juan Chiroque on 21/11/2021 at 10:47 a. m.
 * All rights reserved 2021.
 ****/

class ArtistDetailViewModel: ViewModel() {

    private val _artist = MutableLiveData<Artist>()
    val artist: LiveData<Artist> = _artist

    fun setArtist(artist: Artist) {
        _artist.value = artist
    }

}