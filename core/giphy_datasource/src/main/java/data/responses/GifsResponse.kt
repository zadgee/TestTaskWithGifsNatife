package data.responses

import com.google.gson.annotations.SerializedName

data class GifsResponse(
    @SerializedName("data")
    val gifs:List<GifResponse>
)

data class GifResponse(
    val id:String,
    val title:String,
    @SerializedName("images")
    val images: GifImages
)

data class GifImages(
    @SerializedName("fixed_height_downsampled")
    val small: SmallGif,
)


data class SmallGif(
    @SerializedName("url")
    val gifUrl:String
)