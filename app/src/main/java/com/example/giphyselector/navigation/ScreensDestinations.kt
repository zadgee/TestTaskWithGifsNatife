package com.example.giphyselector.navigation

sealed class ScreensDestinations(val destinationId:String) {
    data object GifsScreen:ScreensDestinations("gifs_screen")
    data object GifDetailsScreen:ScreensDestinations("gif_details_screen")
}