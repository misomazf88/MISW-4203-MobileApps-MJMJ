package com.miso.vinilos.features.album.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miso.vinilos.features.album.domain.entities.Album

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 18/11/2021 at 9:02 a. m.
 * All rights reserved 2021.
 ****/

class AlbumDetailViewModel : ViewModel() {
    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    fun setAlbum(album: Album) {
        _album.value = album
    }
}