package com.shatokhin.navigsuperheroes.presentation.fragments

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.shatokhin.navigsuperheroes.domain.models.PowerStatsHeroParcelable
import com.shatokhin.navigsuperheroes.presentation.fragments.AboutAppFragment
import com.shatokhin.navigsuperheroes.presentation.fragments.DetailsHeroFragment
import com.shatokhin.navigsuperheroes.presentation.fragments.RandomHeroesMainFragment

object Screens {
    fun MainScreenRandomHeroes() = FragmentScreen{ RandomHeroesMainFragment() }
    fun DetailsHero(powerStatsHeroParcelable: PowerStatsHeroParcelable) = FragmentScreen{ DetailsHeroFragment.newInstance(powerStatsHeroParcelable) }
    fun AboutApp() = FragmentScreen{ AboutAppFragment() }
}