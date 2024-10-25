package com.example.giphyselector.navigation

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger
import presentation.ui.GifDetailsScreen
import presentation.ui.GifsScreen

@Composable
fun AppNavigation(
    modifier: Modifier,
    context: Context
){
    val navController = rememberNavController()
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder(context)
                .maxSizePercent(0.4)
                .strongReferencesEnabled(true)
                .build()
        }
        .diskCachePolicy(CachePolicy.ENABLED)
        .diskCache {
            DiskCache.Builder()
                .maxSizePercent(0.30)
                .directory(context.cacheDi
                .build()
        }
        .logger(DebugLogger())
        .build()
    
    NavHost(
        navController = navController,
        startDestination = ScreensDestinations.GifsScreen.destinationId
    ) {
        composable(ScreensDestinations.GifsScreen.destinationId) {
            GifsScreen(
                modifier = modifier,
                onGifClicked = { gifId->
                   navController.navigate("${ScreensDestinations.GifDetailsScreen.destinationId}/$gifId")
                },
                imageLoader = imageLoader
            )
        }

        composable(
            ScreensDestinations.GifDetailsScreen.destinationId + "/{gifId}"
        ) {
            navArgument(
                name = "gifId",
            ){
                type = NavType.StringType
            }
            val gifId = it.arguments?.getString("gifId")

            GifDetailsScreen(
                modifier = modifier,
                retrievedPhotoId = gifId?:"",
                imageLoader = imageLoader
            )
        }
    }
}