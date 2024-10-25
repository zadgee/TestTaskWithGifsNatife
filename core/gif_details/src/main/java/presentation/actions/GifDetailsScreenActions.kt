package presentation.actions

sealed class GifDetailsScreenActions {
    data object OnNextGifChanged:GifDetailsScreenActions()
    data class OnRetrievedGifDetails(val retrievedGifId:String):GifDetailsScreenActions()
    data object OnPreviousGifChanged : GifDetailsScreenActions()
}