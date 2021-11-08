package com.miso.vinilos.features.artist.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso.vinilos.features.artist.data.repository.ArtistRepository
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.artist.domain.useCases.ArtistUseCase
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class ArtistViewModel(artistRepository: ArtistRepository) : ViewModel() {

    private val artistUseCase = ArtistUseCase(artistRepository)
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> = _artists

    init {
        setLoading(true)
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                getArtists()
            }
        }
    }

    fun setLoading(status: Boolean) {
        _loading.value = status
    }

    private fun getArtists() {
        viewModelScope.launch {
            setArtists(artistUseCase.getArtists())
        }
    }

    private fun setArtists(artists: List<Artist>) {
        _artists.value = artists
    }
}