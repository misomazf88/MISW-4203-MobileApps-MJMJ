package com.miso.vinilos.features.album.data.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.data.entities
 * Created by Milena Castillo on 5/11/2021 at 8:04 a. m.
 * All rights reserved 2021.
 ****/

data class Track(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("duration") val duration: String
)
