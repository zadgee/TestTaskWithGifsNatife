package data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "gif_details_table"
)
data class GifDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val gifId:String,
    val title:String,
    val url:String
)