package com.miso.vinilos.features.album.domain.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.domain.entities
 * Created by Milena Castillo on 5/11/2021 at 8:32 a. m.
 * All rights reserved 2021.
 ****/

data class Comment(
    @SerializedName("id") val id: Int,
    @SerializedName("description") val description: String,
    @SerializedName("rating") val rating: Int
)
