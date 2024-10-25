package domain.usecases

import domain.repo.GiphyRepository

class GetGifIndexInsideListByGifIdUseCase(
    private val repository: GiphyRepository
) {

    suspend fun execute(gifId:String):Int{
        return repository.getGifIndexInsideListByGifId(gifId)
    }

}