package com.miso.vinilos.features.album.domain.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.domain.entities
 * Created by Milena Castillo on 5/11/2021 at 7:46 a. m.
 * All rights reserved 2021.
 ****/

data class Albums(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("cover") val cover: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("description") val description: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("recordLabel") val recordLabel: String,
    @SerializedName("tracks") val tracks: List<Track>,
    @SerializedName("performers") val performers: List<Performer>,
    @SerializedName("comments") val comments: List<Comment>
)
