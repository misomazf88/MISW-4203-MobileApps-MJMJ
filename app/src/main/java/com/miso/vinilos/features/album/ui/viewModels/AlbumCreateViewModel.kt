package com.miso.vinilos.features.album.ui.viewModels

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miso.vinilos.features.album.data.repository.AlbumRepository
import com.miso.vinilos.features.album.domain.entities.ResponseValidate
import com.miso.vinilos.features.album.domain.entities.TypeField
import com.miso.vinilos.features.album.domain.useCases.AlbumUseCase
import com.miso.vinilos.features.artist.data.repository.ArtistRepository

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.viewModels
 * Created by Miguel Zapata on 5/12/2021 at 4:37 p. m.
 * All rights reserved 2021.
 ****/

class AlbumCreateViewModel(albumRepository: AlbumRepository, artistRepository: ArtistRepository): ViewModel() {

    private val albumUseCase = AlbumUseCase(albumRepository)
    private val _messageSnackBar = MutableLiveData<String>()
    val messageSnackBar: LiveData<String> = _messageSnackBar
    private val _nameAlbum = MutableLiveData<String>()
    val nameAlbum: LiveData<String> = _nameAlbum
    private val _urlCover = MutableLiveData<String>()
    val urlCover: LiveData<String> = _urlCover
    private val _responseValidated = MutableLiveData<ResponseValidate>()

    fun validateFields(){
        setResponseValidated(albumUseCase.validateIsEmptyField(nameAlbum.value,TypeField.NAME_ALBUM))
        if (!_responseValidated.value!!.status)
            setMessageSnackBar(_responseValidated.value!!.message)
        else{
            setResponseValidated(albumUseCase.validateLengthField(nameAlbum.value,TypeField.NAME_ALBUM,3))
            if (!_responseValidated.value!!.status)
                setMessageSnackBar(_responseValidated.value!!.message)
        }
    }

    private fun setResponseValidated(responseValidate: ResponseValidate) {
        _responseValidated.value = responseValidate
    }

    fun setNameAlbum(data: Editable?) {
        _nameAlbum.value = data.toString()
    }

    fun setUrlCover(data: Editable?) {
        _urlCover.value = data.toString()
    }

    fun setMessageSnackBar(message: String) {
        _messageSnackBar.value = message
    }
}