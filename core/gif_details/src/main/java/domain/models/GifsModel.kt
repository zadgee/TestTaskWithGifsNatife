package domain.models

data class GifsModel(
    val id:Int=0,
    val gifId:String,
    val query:String="",
    val imageUrl:String
)