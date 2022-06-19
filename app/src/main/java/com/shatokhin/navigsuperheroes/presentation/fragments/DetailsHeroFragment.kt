package com.shatokhin.navigsuperheroes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.shatokhin.navigsuperheroes.databinding.FragmentDetailsHeroBinding
import com.shatokhin.navigsuperheroes.domain.models.PowerStatsHeroParcelable
import com.shatokhin.navigsuperheroes.utilites.EXTRA_HERO_PARCELABLE
import com.squareup.picasso.Picasso

class DetailsHeroFragment: Fragment() {

    companion object{
        fun newInstance(powerStatsHeroParcelable: PowerStatsHeroParcelable): DetailsHeroFragment {
            val fragment = DetailsHeroFragment()

            val arg = Bundle()
            arg.putParcelable(EXTRA_HERO_PARCELABLE, powerStatsHeroParcelable)

            fragment.arguments = arg
            return fragment
        }
    }

    private lateinit var binding: FragmentDetailsHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsHeroBinding.inflate(layoutInflater)

        val hero = arguments?.getParcelable<PowerStatsHeroParcelable>(EXTRA_HERO_PARCELABLE)

        if (hero != null){
            setDataHero(hero)
        }
        else {
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun setDataHero(hero: PowerStatsHeroParcelable) {
        Picasso.get()
            .load(hero.imgUrl)
            .into(binding.image)
        binding.hero = hero
    }



}