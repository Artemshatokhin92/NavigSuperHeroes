package com.shatokhin.navigsuperheroes.domain.repository

import com.shatokhin.navigsuperheroes.data.models.SuperHeroJson

interface Repository {

    suspend fun getSuperHeroById(idHero: Int): SuperHeroJson

}