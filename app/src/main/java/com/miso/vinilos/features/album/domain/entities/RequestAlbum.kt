package com.miso.vinilos.features.album.domain.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.domain.entities
 * Created by Juan Chiroque on 5/12/2021 at 7:20 p. m.
 * All rights reserved 2021.
 ****/

data class RequestAlbum(
    @SerializedName("name") val name: String,
    @SerializedName("cover") val cover: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("description") val description: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("recordLabel") val recordLabel: String
)
