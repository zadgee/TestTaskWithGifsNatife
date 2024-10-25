package data.responses

import com.google.gson.annotations.SerializedName

data class SpecificGifResponse(
    @SerializedName("data")
    val data: SpecificGifData
)

data class SpecificGifData(
    @SerializedName("id")
    val gifId:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("images")
    val image: SpecificGifImage
)

data class SpecificGifImage(
    @SerializedName("downsized_still")
    val large: LargeGifImage
)

data class LargeGifImage(
    @SerializedName("url")
    val largeGifUrl:String
)