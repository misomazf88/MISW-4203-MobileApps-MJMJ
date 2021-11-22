package com.miso.vinilos.features.collector.domain.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.domain.entities
 * Created by Miguel Zapata on 21/11/2021 at 7:31 p. m.
 * All rights reserved 2021.
 ****/

data class CollectorAlbums(
    @SerializedName("id") val id: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("status") val status: String
)