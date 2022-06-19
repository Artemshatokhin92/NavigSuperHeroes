package com.shatokhin.navigsuperheroes.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shatokhin.navigsuperheroes.data.repository.RepositoryImpl
import com.shatokhin.navigsuperheroes.domain.usecase.UseCaseGetSuperHeroesById

class ViewModelSuperHeroesFactory(): ViewModelProvider.Factory {
    private val repositoryImpl = RepositoryImpl()

    private val useCaseGetSuperHeroesById = UseCaseGetSuperHeroesById(repositoryImpl)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelSuperHeroes(useCaseGetSuperHeroesById) as T
    }

}