package com.shatokhin.navigsuperheroes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shatokhin.navigsuperheroes.databinding.FragmentAboutAppBinding

class AboutAppFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAboutAppBinding.inflate(layoutInflater).root
    }
}