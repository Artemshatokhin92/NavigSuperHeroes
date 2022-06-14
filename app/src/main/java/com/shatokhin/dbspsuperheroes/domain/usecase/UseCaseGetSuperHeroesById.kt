package com.shatokhin.dbspsuperheroes.domain.usecase

import com.shatokhin.dbspsuperheroes.data.models.SuperHeroJson
import com.shatokhin.dbspsuperheroes.domain.repository.Repository

class UseCaseGetSuperHeroesById(private val repository: Repository) {
    suspend fun execute(idHero: Int): SuperHeroJson {
        return repository.getSuperHeroById(idHero)
    }
}