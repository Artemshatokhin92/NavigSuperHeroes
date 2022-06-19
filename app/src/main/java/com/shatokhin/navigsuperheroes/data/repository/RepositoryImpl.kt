package com.shatokhin.navigsuperheroes.data.repository

import com.shatokhin.navigsuperheroes.App
import com.shatokhin.navigsuperheroes.data.models.SuperHeroJson
import com.shatokhin.navigsuperheroes.domain.repository.Repository

class RepositoryImpl: Repository {
    private val apiSuperHeroes = App.instance.apiSuperHeroes
    private val managerSPStorage = App.instance.managerSPStorage

    override suspend fun getSuperHeroById(idHero: Int): SuperHeroJson {
        return getHeroFromLocalDB(idHero)?: getHeroFromNetwork(idHero)
    }

    private suspend fun getHeroFromNetwork(idHero: Int): SuperHeroJson {
        val hero = apiSuperHeroes.getSuperHeroesById(idHero)
        managerSPStorage.putHero(hero)
        return hero
    }

    private fun getHeroFromLocalDB(idHero: Int): SuperHeroJson? {
        return managerSPStorage.getHeroById(idHero)
    }
}