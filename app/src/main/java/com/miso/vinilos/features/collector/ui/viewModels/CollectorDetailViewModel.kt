package com.miso.vinilos.features.collector.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso.vinilos.features.album.data.repository.AlbumRepository
import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.artist.data.repository.ArtistRepository
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.collector.domain.entities.Collector
import com.miso.vinilos.features.collector.domain.entities.CollectorAlbums
import com.miso.vinilos.features.collector.domain.useCases.CollectorUseCase
import kotlinx.coroutines.launch

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.ui.viewModels
 * Created by Milena Castillo on 4/12/2021 at 6:53 p. m.
 * All rights reserved 2021.
 ****/

class CollectorDetailViewModel(albumRepository: AlbumRepository, artistRepository: ArtistRepository): ViewModel() {

    private val collectorUseCase = CollectorUseCase(null,albumRepository,artistRepository)
    private val _collector = MutableLiveData<Collector>()
    val collector: LiveData<Collector> = _collector
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums
    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> = _artists
    private val albumsInfo: MutableList<Album> = ArrayList()
    private val artistInfo: MutableList<Artist> = ArrayList()

    fun setCollector(collector: Collector) {
        _collector.value = collector
        getAlbums(collector.collectorAlbums)
        getArtists(collector.favoritePerformers)
    }

    private fun getAlbums(collectorAlbums: List<CollectorAlbums>) {
        albumsInfo.clear()
        viewModelScope.launch {
            collectorAlbums.forEach {
                albumsInfo.add(collectorUseCase.getAlbum(it.id))
            }
            setAlbums(albumsInfo)
        }
    }

    private fun getArtists(collectorArtist: List<Artist>) {
        artistInfo.clear()
        viewModelScope.launch {
            collectorArtist.forEach {
                artistInfo.add(collectorUseCase.getArtist(it.id!!))
            }
            setArtist(artistInfo)
        }
    }

    private fun setArtist(artists: List<Artist>) {
        _artists.value = artists
    }

    private fun setAlbums(albums: List<Album>) {
        _albums.value = albums
    }
}