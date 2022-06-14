package com.shatokhin.dbspsuperheroes.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PowerStatsHeroParcelable(
    val name: String,
    val imgUrl: String,
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int,
): Parcelable