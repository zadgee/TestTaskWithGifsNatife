package com.example.giphyselector.glue.gifs_screen.di

import com.example.giphyselector.glue.gifs_screen.repo.GifsScreenRepositoryImpl
import domain.GifsMediatorFactory
import domain.repo.GifsScreenRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.viewModel.GifsScreenViewModel

val gifsScreenModule = module {
    single<GifsScreenRepository> {
        GifsScreenRepositoryImpl(
            gifsMediatorFactory = get(),
            dao = get()
        )
    }
}


val gifsScreenViewModelModule = module {
    viewModel {
        GifsScreenViewModel(
            repository = get(),
        )
    }
    factory {
        GifsMediatorFactory(
            api = get(),
            db = get()
        )
    }
}