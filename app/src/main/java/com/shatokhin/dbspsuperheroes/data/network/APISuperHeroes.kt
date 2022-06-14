package com.shatokhin.dbspsuperheroes.data.network

import com.shatokhin.dbspsuperheroes.data.models.SuperHeroJson
import retrofit2.http.GET
import retrofit2.http.Path

interface APISuperHeroes {

    @GET("id/{id}.json")
    suspend fun getSuperHeroesById(@Path("id") idHero: Int): SuperHeroJson

}