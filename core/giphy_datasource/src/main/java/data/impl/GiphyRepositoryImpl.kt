package data.impl
import androidx.paging.PagingSource
import data.api.GiphyAPI
import data.dao.GifsDao
import data.entity.GifDetailsEntity
import data.entity.GifEntity
import domain.mapper.toGifDetailsEntity
import domain.repo.GiphyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class GiphyRepositoryImpl(
    private val dao: GifsDao,
    private val api:GiphyAPI
):GiphyRepository {

    override suspend fun getGifById(id: String): GifDetailsEntity = withContext(Dispatchers.IO) {
            val networkRequest = api.getGifById(id)
            if(networkRequest.isSuccessful){
                val body = networkRequest.body()?.toGifDetailsEntity() ?: GifDetailsEntity(
                    gifId = "",
                    title = "",
                    url = "",
                    id = -1
                )
                async {
                    dao.insertGifDetails(body)
                }.await()
                dao.getGifDetailsById(id)
            } else {
                GifDetailsEntity(
                    gifId = "",
                    title = "",
                    url = "",
                    id = -1
                )
            }
    }

    override fun getTrendingGifs(): PagingSource<Int, GifEntity> {
        return dao.gifsPagingSource()
    }

    override suspend fun updateGifDetails(gifId:String):GifDetailsEntity = withContext(
        Dispatchers.IO
    ){
        val networkRequest = api.getGifById(gifId)
        if(networkRequest.isSuccessful){
            val body = networkRequest.body()?.toGifDetailsEntity() ?: GifDetailsEntity(
                gifId = "",
                title = "",
                url = "",

            )
            async {
                dao.insertGifDetails(body)
            }.await()

            GifDetailsEntity(
                gifId = body.gifId,
                title = body.title,
                url = body.url
            )
        } else {
            GifDetailsEntity(
                gifId = "",
                title = "",
                url = "",
            )
        }
    }

    override suspend fun getGifIndexInsideListByGifId(gifId: String): Int {
        return dao.getGifIndexInsideListByGifId(gifId)
    }

    override suspend fun getGifIdByPosition(id: Int): String {
        return dao.getGifIdByPosition(id)
    }

    override fun searchGifs(query:String): PagingSource<Int, GifEntity> {
        return dao.getGifsByQuery(query)
    }
}