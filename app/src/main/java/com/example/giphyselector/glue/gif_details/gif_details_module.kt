package com.example.giphyselector.glue.gif_details

import domain.repo.GifDetailsRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.viewModel.GifDetailsViewModel

val gifDetailsModule = module {
    single<GifDetailsRepository> {
        GifDetailsRepositoryImpl(
            get(),get(), get(), get()
        )
    }
}

val gifDetailsViewModelModule = module {
    viewModel {
        GifDetailsViewModel(
            repository = get(),
        )
    }
}