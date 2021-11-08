package com.miso.vinilos.features.artist.domain.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.domain.entities
 * Created by Juan Jose Chiroque on 7/11/2021 at 4:59 p. m.
 * All rights reserved 2021.
 ****/

data class Prize(
    @SerializedName("id") val id: Int,
    @SerializedName("premiationDate") val premiationDate: String
)
