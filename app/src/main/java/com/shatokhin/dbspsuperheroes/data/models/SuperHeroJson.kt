package com.shatokhin.dbspsuperheroes.data.models

import com.google.gson.annotations.SerializedName

data class SuperHeroJson(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("powerstats")
    val powerStatsJson: PowerStatsJson,
    @SerializedName("images")
    val image: ImageJson
    )