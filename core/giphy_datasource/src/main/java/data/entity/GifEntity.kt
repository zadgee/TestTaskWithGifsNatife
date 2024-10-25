package data.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "gif_table",
)
data class GifEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val gifId:String,
    val query:String="",
    val imageUrl:String
)