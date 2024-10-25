package data.api

import com.example.giphy_datasource.BuildConfig
import data.responses.GifsResponse
import data.responses.SpecificGifResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GiphyAPI {

    @GET("gifs/search?api_key=${BuildConfig.apiKey}")
    suspend fun searchGifs(
        @Query("limit") pageSize:Int,
        @Query("offset") page:Int,
        @Query("q") query:String=""
    ): Response<GifsResponse>

    @GET("gifs/{gif_id}?api_key=${BuildConfig.apiKey}")
    suspend fun getGifById(
        @Path("gif_id") id:String
    ): Response<SpecificGifResponse>

    @GET("gifs/trending/?api_key=${BuildConfig.apiKey}")
    suspend fun getTrendingGifs(
        @Query("limit") pageSize:Int,
        @Query("offset") page:Int
    ): Response<GifsResponse>

}