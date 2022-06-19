package com.shatokhin.navigsuperheroes.data.network

import com.shatokhin.navigsuperheroes.data.models.SuperHeroJson
import retrofit2.http.GET
import retrofit2.http.Path

interface APISuperHeroes {

    @GET("id/{id}.json")
    suspend fun getSuperHeroesById(@Path("id") idHero: Int): SuperHeroJson

}