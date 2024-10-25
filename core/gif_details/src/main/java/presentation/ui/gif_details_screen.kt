package presentation.ui
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import coil.ImageLoader
import me.saket.swipe.rememberSwipeableActionsState
import org.koin.compose.viewmodel.koinViewModel
import presentation.viewModel.GifDetailsViewModel

@Composable
fun GifDetailsScreen(
    modifier: Modifier,
    retrievedPhotoId: String,
    imageLoader: ImageLoader
) {
    val viewModel = koinViewModel<GifDetailsViewModel>()
    val gifDetails = viewModel.gifDetails.collectAsState()
    val positionState = viewModel.gifPositionState.collectAsState()
    val dismissState = rememberSwipeableActionsState()
    Log.d("TAG", "positionState: ${positionState.value}")


    GifDetailsComponent(
        modifier = modifier,
        gifDetails = gifDetails.value,
        onAction = viewModel::onAction,
        retrievedPhotoId = retrievedPhotoId,
        swipeState = dismissState,
        imageLoader = imageLoader
    )
}