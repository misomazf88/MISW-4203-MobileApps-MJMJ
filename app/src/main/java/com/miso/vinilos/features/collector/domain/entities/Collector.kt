package com.miso.vinilos.features.collector.domain.entities

import com.google.gson.annotations.SerializedName
import com.miso.vinilos.features.album.domain.entities.Comment
import com.miso.vinilos.features.artist.domain.entities.Artist

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.domain.entities
 * Created by Miguel Zapata on 21/11/2021 at 7:26 p. m.
 * All rights reserved 2021.
 ****/

data class Collector(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("telephone") val telephone: String,
    @SerializedName("email") val email: String,
    @SerializedName("comments") val comments: List<Comment>,
    @SerializedName("favoritePerformers") val favoritePerformers: List<Artist>,
    @SerializedName("collectorAlbums") val collectorAlbums: List<CollectorAlbums>
)
