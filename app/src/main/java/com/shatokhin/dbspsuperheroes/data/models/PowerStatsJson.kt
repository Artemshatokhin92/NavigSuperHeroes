package com.shatokhin.dbspsuperheroes.data.models

import com.google.gson.annotations.SerializedName

data class PowerStatsJson(
    @SerializedName("intelligence")
    val intelligence: Int,
    @SerializedName("strength")
    val strength: Int,
    @SerializedName("speed")
    val speed: Int,
    @SerializedName("durability")
    val durability: Int,
    @SerializedName("power")
    val power: Int,
    @SerializedName("combat")
    val combat: Int,
)