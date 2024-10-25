package domain
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import data.api.GiphyAPI
import data.db.AppDatabase
import data.entity.GifEntity
import domain.mapper.toGifEntity
import java.io.IOException


@OptIn(ExperimentalPagingApi::class)
class GifsMediator(
    private val api:GiphyAPI,
    private val db: AppDatabase,
    private val query:String
): RemoteMediator<Int, GifEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GifEntity>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null){
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val response = if(query.isEmpty()){
                api.getTrendingGifs(
                    pageSize = state.config.pageSize,
                    page = loadKey
                )
            } else {
                api.searchGifs(
                    pageSize = state.config.pageSize,
                    page = loadKey,
                    query = query
                )
            }
            db.withTransaction {
                if(loadType == LoadType.REFRESH){
                    db.dao().clearGifs()
                }
                val gifEntity = response.body()?.gifs?.map { it.toGifEntity() } ?: emptyList()
                db.dao().insertGifs(gifEntity)
                MediatorResult.Success(
                    endOfPaginationReached = response.body()?.gifs?.isEmpty() ?:true
                )
            }
        }catch (e: IOException){
            MediatorResult.Error(e)
        }
    }
}


class GifsMediatorFactory(
    private val api: GiphyAPI,
    private val db: AppDatabase
) {
    fun create(query: String): GifsMediator {
        return GifsMediator(api, db, query)
    }
}