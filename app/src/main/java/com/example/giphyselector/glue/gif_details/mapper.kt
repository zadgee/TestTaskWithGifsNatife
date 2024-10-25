package com.example.giphyselector.glue.gif_details

import data.entity.GifDetailsEntity
import data.entity.GifEntity
import domain.models.GifDetailsModel
import domain.models.GifsModel

fun GifDetailsEntity.toGifDetailsModel(): GifDetailsModel {
    return GifDetailsModel(
        gifId = gifId,
        title = title,
        url = url,
        id = id
    )
}

fun GifDetailsModel.toGifDetailsEntity():GifDetailsEntity{
    return GifDetailsEntity(
        gifId = gifId,
        title = title,
        url = url,
        id = id
    )
}

fun GifEntity.toGifsModel(): GifsModel{
    return GifsModel(
        gifId = gifId,
        query = query,
        imageUrl = imageUrl,
    )
}