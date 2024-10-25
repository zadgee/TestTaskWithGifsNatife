package di.db

import android.content.Context
import androidx.room.Room
import data.dao.GifsDao
import data.db.AppDatabase
import domain.repo.GiphyRepository
import domain.usecases.GetGifByIdUseCase
import domain.usecases.GetGifIdByPositionUseCase
import domain.usecases.GetGifIndexInsideListByGifIdUseCase
import domain.usecases.UpdateGifDetailsUseCase


fun provideRoomDataBaseInstance(
    context:Context
): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database"
    ).build()
}


fun provideGifsDao(db: AppDatabase): GifsDao {
    return db.dao()
}

fun provideGifByIdUseCase(
    repository: GiphyRepository
):GetGifByIdUseCase{
    return GetGifByIdUseCase(repository)
}

fun provideUpdateGifDetailsUseCase(
    repository: GiphyRepository
): UpdateGifDetailsUseCase{
    return UpdateGifDetailsUseCase(
        repository
    )
}

fun provideGetGifIdByPositionUseCase(
    repository: GiphyRepository
): GetGifIdByPositionUseCase{
    return GetGifIdByPositionUseCase(
        repository
    )
}

fun provideGetGifIndexInsideListByGifIdUseCase(
    repository: GiphyRepository
): GetGifIndexInsideListByGifIdUseCase {
    return GetGifIndexInsideListByGifIdUseCase(
        repository
    )
}