package presentation.ui

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger
import org.koin.compose.viewmodel.koinViewModel
import presentation.viewModel.GifsScreenViewModel

@Composable
fun GifsScreen(
    modifier: Modifier,
    onGifClicked:(gifId:String)->Unit,
    imageLoader: ImageLoader
){
    val viewModel = koinViewModel<GifsScreenViewModel>()
    val searchText = viewModel.searchText.collectAsState()
    val isSearching = viewModel.isSearching.collectAsState()
    val gifs = viewModel.pagedGifsFlow.collectAsLazyPagingItems()

    GifsScreenComponent(
        modifier = modifier,
        isSearching = isSearching.value,
        searchText = searchText.value,
        onAction = viewModel::onAction,
        gifs = gifs,
        onGifClicked = onGifClicked,
        imageLoader = imageLoader
    )
}