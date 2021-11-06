package com.miso.vinilos.features.album.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso.vinilos.features.album.data.repository.AlbumRepository
import com.miso.vinilos.features.album.domain.entities.Albums
import com.miso.vinilos.features.album.domain.useCases.AlbumUseCase
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class AlbumViewModel(albumRepository: AlbumRepository) : ViewModel() {

    private val albumUseCase = AlbumUseCase(albumRepository)
    private val _albums = MutableLiveData<List<Albums>>()
    val albums: LiveData<List<Albums>> = _albums

    init {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                getAlbums()
            }
        }
    }

    private fun getAlbums() {
        viewModelScope.launch {
            setAlbums(albumUseCase.getAlbums())
        }
    }

    private fun setAlbums(albums: List<Albums>) {
        _albums.value = albums
    }

}