package com.shatokhin.dbspsuperheroes

import android.app.Application
import com.google.gson.Gson
import com.shatokhin.dbspsuperheroes.data.localstorage.ManagerSPStorage
import com.shatokhin.dbspsuperheroes.data.network.APISuperHeroes
import com.shatokhin.dbspsuperheroes.utilites.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    lateinit var apiSuperHeroes: APISuperHeroes
    lateinit var managerSPStorage: ManagerSPStorage

    override fun onCreate() {
        super.onCreate()

        instance = this

        initRetrofit()

        managerSPStorage = ManagerSPStorage(applicationContext)
    }

    private fun initRetrofit() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC


        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        apiSuperHeroes = retrofit.create(APISuperHeroes::class.java)

    }
}