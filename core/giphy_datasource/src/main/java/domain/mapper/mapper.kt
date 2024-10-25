package domain.mapper

import data.entity.GifDetailsEntity
import data.entity.GifEntity
import data.responses.GifResponse
import data.responses.SpecificGifResponse

fun GifResponse.toGifEntity():GifEntity{
    return GifEntity(
        gifId = id,
        imageUrl = images.small.gifUrl,
    )
}

fun SpecificGifResponse.toGifDetailsEntity():GifDetailsEntity{
    return GifDetailsEntity(
        url = data.image.large.largeGifUrl,
        gifId = data.gifId,
        title = data.title
    )
}