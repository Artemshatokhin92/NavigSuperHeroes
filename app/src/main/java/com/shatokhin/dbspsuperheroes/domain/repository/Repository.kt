package com.shatokhin.dbspsuperheroes.domain.repository

import com.shatokhin.dbspsuperheroes.data.models.SuperHeroJson

interface Repository {

    suspend fun getSuperHeroById(idHero: Int): SuperHeroJson

}