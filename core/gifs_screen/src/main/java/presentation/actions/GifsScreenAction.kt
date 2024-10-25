package presentation.actions

sealed class GifsScreenAction {
    data class onSearchTextChanged(val text:String):GifsScreenAction()
}