package domain.repo

import androidx.paging.PagingSource
import data.entity.GifDetailsEntity
import data.entity.GifEntity

interface GiphyRepository {
    suspend fun getGifById(id: String):GifDetailsEntity
    fun getTrendingGifs():PagingSource<Int, GifEntity>
    suspend fun updateGifDetails(gifId:String):GifDetailsEntity
    suspend fun getGifIndexInsideListByGifId(gifId:String):Int
    suspend fun getGifIdByPosition(id:Int):String
    fun searchGifs(query:String):PagingSource<Int, GifEntity>
}