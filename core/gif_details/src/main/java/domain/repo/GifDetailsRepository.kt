package domain.repo

import domain.models.GifDetailsModel
import domain.models.GifsModel

interface GifDetailsRepository {
    suspend fun getGifById(id: String): GifDetailsModel
    suspend fun updateGifDetails(id:String):GifDetailsModel
    suspend fun getGifIdByPosition(id:Int):String
    suspend fun getGifIndexInsideListByGifId(gifId:String):Int
}