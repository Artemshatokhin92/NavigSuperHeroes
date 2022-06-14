package com.shatokhin.dbspsuperheroes.data.models

import com.google.gson.annotations.SerializedName

data class ImageJson(
    @SerializedName("lg")
    val url: String,
)