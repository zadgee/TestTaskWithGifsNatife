package com.example.giphyselector.glue.gif_details
import android.util.Log
import domain.models.GifDetailsModel
import domain.models.GifsModel
import domain.repo.GifDetailsRepository
import domain.usecases.GetGifByIdUseCase
import domain.usecases.GetGifIdByPositionUseCase
import domain.usecases.GetGifIndexInsideListByGifIdUseCase
import domain.usecases.UpdateGifDetailsUseCase

class GifDetailsRepositoryImpl(
    private val updateGifDetailsUseCase: UpdateGifDetailsUseCase,
    private val getGifByIdUseCase: GetGifByIdUseCase,
    private val getGifIdByPositionUseCase: GetGifIdByPositionUseCase,
    private val getGifIndexInsideListByGifIdUseCase: GetGifIndexInsideListByGifIdUseCase
):GifDetailsRepository {
    override suspend fun getGifById(id: String): GifDetailsModel {
        return getGifByIdUseCase.execute(id).toGifDetailsModel()
    }

    override suspend fun updateGifDetails(id: String): GifDetailsModel {
        return updateGifDetailsUseCase.execute(id).toGifDetailsModel()
    }

    override suspend fun getGifIdByPosition(id: Int):String {
        return getGifIdByPositionUseCase.execute(id)
    }

    override suspend fun getGifIndexInsideListByGifId(gifId: String): Int {
        return getGifIndexInsideListByGifIdUseCase.execute(gifId)
    }
}