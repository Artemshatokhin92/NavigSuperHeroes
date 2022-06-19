package com.shatokhin.navigsuperheroes.domain.models

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
): Parcelable {
    fun intelligenceString() = intelligence.toString()
    fun strengthString() = strength.toString()
    fun speedString() = speed.toString()
    fun durabilityString() = durability.toString()
    fun powerString() = power.toString()
    fun combatString() = combat.toString()
}