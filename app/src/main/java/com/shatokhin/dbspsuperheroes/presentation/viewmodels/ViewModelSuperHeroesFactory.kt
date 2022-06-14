package com.shatokhin.dbspsuperheroes.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shatokhin.dbspsuperheroes.data.repository.RepositoryImpl
import com.shatokhin.dbspsuperheroes.domain.usecase.UseCaseGetSuperHeroesById

class ViewModelSuperHeroesFactory(): ViewModelProvider.Factory {
    private val repositoryImpl = RepositoryImpl()

    private val useCaseGetSuperHeroesById = UseCaseGetSuperHeroesById(repositoryImpl)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelSuperHeroes(useCaseGetSuperHeroesById) as T
    }

}