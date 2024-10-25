package com.example.giphyselector.application
import android.app.Application
import com.example.giphyselector.glue.gif_details.gifDetailsModule
import com.example.giphyselector.glue.gif_details.gifDetailsViewModelModule
import com.example.giphyselector.glue.gifs_screen.di.gifsScreenModule
import com.example.giphyselector.glue.gifs_screen.di.gifsScreenViewModelModule
import di.db.databaseModule
import di.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GiphySelectorApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
              databaseModule, networkModule,
              gifsScreenModule, gifsScreenViewModelModule,
              gifDetailsModule, gifDetailsViewModelModule
            )
        }
    }
}