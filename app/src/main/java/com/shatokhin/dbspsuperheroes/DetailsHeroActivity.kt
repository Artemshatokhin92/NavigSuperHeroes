package com.shatokhin.dbspsuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shatokhin.dbspsuperheroes.databinding.ActivityDetailsHeroBinding
import com.shatokhin.dbspsuperheroes.domain.models.PowerStatsHeroParcelable
import com.shatokhin.dbspsuperheroes.utilites.EXTRA_HERO_PARCELABLE
import com.squareup.picasso.Picasso

class DetailsHeroActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = intent.getParcelableArrayListExtra<PowerStatsHeroParcelable>(EXTRA_HERO_PARCELABLE)

        val hero = list?.get(0)

        if (hero != null){
            setDataHero(hero)
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        }
    }

    private fun setDataHero(hero: PowerStatsHeroParcelable) {
        Picasso.get()
            .load(hero.imgUrl)
            .into(binding.image)
        binding.tvName.text = hero.name
        binding.tvValueIntelligence.text = hero.intelligence.toString()
        binding.tvValueStrength.text = hero.strength.toString()
        binding.tvValueSpeed.text = hero.speed.toString()
        binding.tvValueDurability.text = hero.durability.toString()
        binding.tvValuePower.text = hero.power.toString()
        binding.tvValueCombat.text = hero.combat.toString()
    }
}