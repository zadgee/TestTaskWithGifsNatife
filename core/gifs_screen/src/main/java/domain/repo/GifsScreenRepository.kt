package domain.repo

import androidx.paging.PagingData
import domain.models.PagedGifsModel
import kotlinx.coroutines.flow.Flow

interface GifsScreenRepository {
    suspend fun updateGifsList(pagedGifsModel: PagedGifsModel)
    fun gifsPagingSource(query:String):Flow<PagingData<PagedGifsModel>>
}