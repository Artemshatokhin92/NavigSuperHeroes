package com.shatokhin.dbspsuperheroes.data.repository

import com.shatokhin.dbspsuperheroes.App
import com.shatokhin.dbspsuperheroes.data.models.SuperHeroJson
import com.shatokhin.dbspsuperheroes.domain.repository.Repository

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