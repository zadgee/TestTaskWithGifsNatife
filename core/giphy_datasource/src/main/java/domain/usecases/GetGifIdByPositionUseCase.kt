package domain.usecases

import data.entity.GifEntity
import domain.repo.GiphyRepository

class GetGifIdByPositionUseCase(
    private val repository: GiphyRepository
) {

    suspend fun execute(id:Int):String{
        return repository.getGifIdByPosition(id)
    }
}