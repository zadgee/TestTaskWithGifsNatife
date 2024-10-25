package domain.usecases
import data.entity.GifDetailsEntity
import domain.repo.GiphyRepository

class UpdateGifDetailsUseCase(
    private val repository: GiphyRepository
) {

    suspend fun execute(
        gifId:String
    ): GifDetailsEntity {
        return repository.updateGifDetails(gifId)
    }

}