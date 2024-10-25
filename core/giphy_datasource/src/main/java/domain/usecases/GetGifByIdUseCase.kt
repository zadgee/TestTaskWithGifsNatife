package domain.usecases

import data.entity.GifDetailsEntity
import data.entity.GifEntity
import domain.repo.GiphyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetGifByIdUseCase(
    private val repository: GiphyRepository
) {

    suspend fun execute(
        id:String
    ): GifDetailsEntity{
        return repository.getGifById(id)
    }


}