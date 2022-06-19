package com.shatokhin.navigsuperheroes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.shatokhin.navigsuperheroes.data.models.SuperHeroJson
import com.shatokhin.navigsuperheroes.databinding.FragmentRandomHeroesMainBinding
import com.shatokhin.navigsuperheroes.domain.models.PowerStatsHeroParcelable
import com.shatokhin.navigsuperheroes.presentation.adapters.AdapterRvSuperHeroes
import com.shatokhin.navigsuperheroes.presentation.viewmodels.ViewModelSuperHeroes
import com.shatokhin.navigsuperheroes.presentation.viewmodels.ViewModelSuperHeroesFactory

class RandomHeroesMainFragment: Fragment() {
    lateinit var binding: FragmentRandomHeroesMainBinding
    private val viewModelListAllHeroes: ViewModelSuperHeroes by activityViewModels { ViewModelSuperHeroesFactory() }
    private lateinit var adapterRvSuperHeroes: AdapterRvSuperHeroes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomHeroesMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycleView()

        binding.btnLoadRandomHeroes.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            viewModelListAllHeroes.loadRandomHeroes(20)
        }

        binding.btnAboutApp.setOnClickListener {
            viewModelListAllHeroes.showAboutApp()
        }
    }

    private fun initRecycleView() {
        val clickListener = object : AdapterRvSuperHeroes.ClickListenerSuperHero{
            override fun clickHero(hero: SuperHeroJson) {
                val powerStatsHeroParcelable = PowerStatsHeroParcelable(
                    hero.name,
                    hero.image.url,
                    hero.powerStatsJson.intelligence,
                    hero.powerStatsJson.strength,
                    hero.powerStatsJson.speed,
                    hero.powerStatsJson.durability,
                    hero.powerStatsJson.power,
                    hero.powerStatsJson.combat
                )
                viewModelListAllHeroes.showDetailsHero(powerStatsHeroParcelable)
            }
        }

        adapterRvSuperHeroes = AdapterRvSuperHeroes(clickListener)
        binding.rvHeroes.adapter = adapterRvSuperHeroes

        val lmForRvHeroes = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.rvHeroes.layoutManager = lmForRvHeroes

        viewModelListAllHeroes.listSuperHeroJson.observe(viewLifecycleOwner){ listRandomSuperHeroes ->
            binding.progressBar.visibility = View.GONE
            adapterRvSuperHeroes.submitList(listRandomSuperHeroes)
        }

    }

}