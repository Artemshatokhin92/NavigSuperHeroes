package com.shatokhin.navigsuperheroes.domain.usecase

import com.shatokhin.navigsuperheroes.data.models.SuperHeroJson
import com.shatokhin.navigsuperheroes.domain.repository.Repository

class UseCaseGetSuperHeroesById(private val repository: Repository) {
    suspend fun execute(idHero: Int): SuperHeroJson {
        return repository.getSuperHeroById(idHero)
    }
}