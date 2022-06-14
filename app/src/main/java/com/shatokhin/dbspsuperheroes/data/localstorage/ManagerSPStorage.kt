package com.shatokhin.dbspsuperheroes.data.localstorage

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.shatokhin.dbspsuperheroes.data.models.SuperHeroJson
import com.shatokhin.dbspsuperheroes.utilites.NAME_FILE_HEROES
import com.shatokhin.dbspsuperheroes.utilites.TAG_FOR_LOGCAT

class ManagerSPStorage(private val appContext: Context) {
    private val preferences: SharedPreferences = appContext.getSharedPreferences(NAME_FILE_HEROES, Context.MODE_PRIVATE)

    fun getHeroById(id: Int): SuperHeroJson? {
//        Log.d(TAG_FOR_LOGCAT, "ManagerSPStorage - getHeroById $id")
        val json = preferences.getString(id.toString(), "")

        if (json != null && json.isNotEmpty()){
//            Log.d(TAG_FOR_LOGCAT, "return Gson")
            return Gson().fromJson(json, SuperHeroJson::class.java)
        }
//        Log.d(TAG_FOR_LOGCAT, "return null")
        return null
    }

    fun putHero(superHeroJson: SuperHeroJson){
//        Log.d(TAG_FOR_LOGCAT, "ManagerSPStorage - putHero ${superHeroJson.id}")
        val hero = Gson().toJson(superHeroJson)
        preferences.edit()
            .putString(superHeroJson.id.toString(), hero)
            .apply()
    }

    fun removeAllHeroes(){
        preferences.edit()
            .clear()
            .apply()
    }
}