package com.miso.vinilos.features.artist.domain.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.domain.entities
 * Created by Juan Chiroque on 5/12/2021 at 7:26 p. m.
 * All rights reserved 2021.
 ****/

data class RequestArtist(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String,
    @SerializedName("birthDate") val birthDate: String
)
