package com.miso.vinilos.features.album.domain.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.domain.entities
 * Created by Mileno Castillo on 5/11/2021 at 8:29 a. m.
 * All rights reserved 2021.
 ****/

data class Performer(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String,
    @SerializedName("birthDate") val birthDate: String
)
