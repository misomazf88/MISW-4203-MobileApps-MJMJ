package com.miso.vinilos.features.artist.domain.entities

import com.google.gson.annotations.SerializedName
import com.miso.vinilos.features.album.domain.entities.Album

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.domain.entities
 * Created by Juan Jose Chiroque on 7/11/2021 at 4:40 p. m.
 * All rights reserved 2021.
 ****/

data class Artist(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String,
    @SerializedName("birthDate") val birthDate: String,
    @SerializedName("albums") val albums: List<Album>,
    @SerializedName("performerPrizes") val performerPrizes: List<Prize>
)
