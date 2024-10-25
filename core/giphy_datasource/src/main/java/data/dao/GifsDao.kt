package data.dao
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import data.entity.GifDetailsEntity
import data.entity.GifEntity

@Dao
interface GifsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGifs(gifs:List<GifEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGifDetails(gif:GifDetailsEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateGifDetails(gifDetails:GifDetailsEntity)

    @Query(
        "SELECT * FROM gif_details_table WHERE gifId = :gifId"
    )
    suspend fun getGifDetailsById(
        gifId:String
    ):GifDetailsEntity

    @Query("SELECT * FROM gif_table")
    fun gifsPagingSource(): PagingSource<Int, GifEntity>

    @Query("SELECT * FROM gif_table WHERE `query` = :query")
    fun getGifsByQuery(query:String):PagingSource<Int, GifEntity>

    @Query("DELETE FROM gif_table")
    suspend fun clearGifs()

    @Query("SELECT id FROM gif_table WHERE gifId = :gifId")
    suspend fun getGifIndexInsideListByGifId(gifId:String):Int

    @Query("SELECT gifId FROM gif_table WHERE `id` = :id")
    suspend fun getGifIdByPosition(id:Int):String

    @Update
    suspend fun updateGifsList(gifEntity: GifEntity)
}