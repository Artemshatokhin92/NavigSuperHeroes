package com.shatokhin.navigsuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.shatokhin.navigsuperheroes.databinding.ActivityMainBinding
import com.shatokhin.navigsuperheroes.presentation.fragments.Screens.MainScreenRandomHeroes
import com.shatokhin.navigsuperheroes.presentation.viewmodels.ViewModelSuperHeroes
import com.shatokhin.navigsuperheroes.presentation.viewmodels.ViewModelSuperHeroesFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModelListAllHeroes: ViewModelSuperHeroes by viewModels { ViewModelSuperHeroesFactory() }
    private lateinit var navigator: AppNavigator
    private val router = App.instance.router
    private val navigatorHolder = App.instance.navigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigator = AppNavigator(this, R.id.fragmentContainer)

        router.newRootScreen(MainScreenRandomHeroes())

    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        router.exit()
    }

}