package di.db
import data.impl.GiphyRepositoryImpl
import domain.repo.GiphyRepository
import org.koin.dsl.module

val databaseModule = module{
    single { provideRoomDataBaseInstance(get()) }
    single { provideGifsDao(get()) }
    single<GiphyRepository> { GiphyRepositoryImpl(get(), get()) }
    single { provideGifByIdUseCase(get()) }
    single { provideUpdateGifDetailsUseCase(get()) }
    single { provideGetGifIdByPositionUseCase(get()) }
    single { provideGetGifIndexInsideListByGifIdUseCase(get()) }
}
