package com.example.giphyselector.glue.gifs_screen.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.giphyselector.glue.gifs_screen.mapper.toGifEntity
import com.example.giphyselector.glue.gifs_screen.mapper.toPagedGifsModel
import data.dao.GifsDao
import domain.GifsMediatorFactory
import domain.models.PagedGifsModel
import domain.repo.GifsScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalPagingApi::class)
class GifsScreenRepositoryImpl(
    private val gifsMediatorFactory: GifsMediatorFactory,
    private val dao: GifsDao
):GifsScreenRepository {
    override suspend fun updateGifsList(pagedGifsModel: PagedGifsModel) {
        return dao.updateGifsList(pagedGifsModel.toGifEntity())
    }

    override fun gifsPagingSource(query: String): Flow<PagingData<PagedGifsModel>> {
       return Pager(
           config = PagingConfig(pageSize = 20),
           pagingSourceFactory = {
               dao.gifsPagingSource()
           }, remoteMediator = gifsMediatorFactory.create(query)

       ).flow.map { pagingData->
           pagingData.map {
               it.toPagedGifsModel()
           }
       }
    }
}