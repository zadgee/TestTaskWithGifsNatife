package com.example.giphyselector.glue.gifs_screen.mapper

import data.entity.GifEntity
import domain.models.PagedGifsModel

fun GifEntity.toPagedGifsModel(): PagedGifsModel {
    return PagedGifsModel(
        query = query,
        gifId = gifId,
        imageUrl = imageUrl,
    )
}

fun PagedGifsModel.toGifEntity(): GifEntity {
    return GifEntity(
        gifId = gifId,
        imageUrl = imageUrl,
    )
}