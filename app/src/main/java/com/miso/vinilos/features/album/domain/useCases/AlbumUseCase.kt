package com.miso.vinilos.features.album.domain.useCases

import com.miso.vinilos.features.album.data.repository.AlbumRepository
import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.album.domain.entities.ResponseValidate
import com.miso.vinilos.features.album.domain.entities.TypeField

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.domain.useCases
 * Created by Miguel Zapata on 5/11/2021 at 9:06 p. m.
 * All rights reserved 2021.
 ****/

class AlbumUseCase(private val albumRepository: AlbumRepository) {

    suspend fun getAlbums(): List<Album> {
        return albumRepository.getAlbumsRemote()
    }

    fun validateIsEmptyField(data: String?, type: TypeField): ResponseValidate {
        var status = false
        var msg = ""
        if (data == null)
            msg = "El campo " + type.value + " esta vacío"
        else
            status = true
        return ResponseValidate(status,msg)
    }

    fun validateLengthField(data: String?, type: TypeField, num: Int): ResponseValidate {
        var status = false
        var msg = ""
        if (data!!.length < num)
            msg = "El " + type.value + " debe tener mínimo " + num + " caracteres"
        else
            status = true
        return ResponseValidate(status,msg)
    }

}