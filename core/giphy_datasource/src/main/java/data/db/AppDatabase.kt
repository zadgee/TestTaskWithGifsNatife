package data.db
import androidx.room.Database
import androidx.room.RoomDatabase
import data.dao.GifsDao
import data.entity.GifDetailsEntity
import data.entity.GifEntity

@Database(
    entities = [
        GifEntity::class,
        GifDetailsEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun dao():GifsDao
}