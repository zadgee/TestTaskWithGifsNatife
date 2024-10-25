package presentation.ui
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.ImageLoader
import coil.compose.AsyncImage
import domain.models.GifDetailsModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import me.saket.swipe.SwipeableActionsState
import presentation.actions.GifDetailsScreenActions


@Composable
fun GifDetailsComponent(
    modifier: Modifier,
    gifDetails:GifDetailsModel,
    onAction:(GifDetailsScreenActions)->Unit,
    retrievedPhotoId:String,
    swipeState: SwipeableActionsState,
    imageLoader: ImageLoader
){

    val nextGif = SwipeAction(
        onSwipe = {
            onAction(GifDetailsScreenActions.OnNextGifChanged)
        },
        icon = {

        },
        background = Color.Unspecified
    )

    val previousGif = SwipeAction(
        onSwipe = {
            onAction(GifDetailsScreenActions.OnPreviousGifChanged)
        },
        icon = {

        },
        background = Color.Unspecified
    )

    LaunchedEffect(key1 = Unit) {
        onAction(
            GifDetailsScreenActions.OnRetrievedGifDetails(
                retrievedPhotoId
            )
        )
    }

    SwipeableActionsBox(
        state = swipeState,
        startActions = listOf(previousGif),
        endActions = listOf(nextGif),
    ) {
        AsyncImage(
            model = gifDetails.url,
            contentDescription = "Big image",
            modifier = modifier.fillMaxSize(),
            imageLoader = imageLoader
            )
    }

}