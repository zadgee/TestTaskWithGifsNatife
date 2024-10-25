package presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.ImageLoader
import coil.compose.AsyncImage
import domain.models.PagedGifsModel
import presentation.actions.GifsScreenAction

@Composable
fun GifsScreenComponent(
    modifier: Modifier,
    searchText:String,
    onAction: (GifsScreenAction) -> Unit,
    isSearching:Boolean,
    gifs:LazyPagingItems<PagedGifsModel>,
    onGifClicked:(gifId:String)->Unit,
    imageLoader: ImageLoader
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column {
            TextField(
                value = searchText,
                onValueChange = {
                    onAction(GifsScreenAction.onSearchTextChanged(it))
                },
                modifier = modifier.fillMaxWidth(),
                placeholder = { Text(text = "Search") }
            )

            Spacer(modifier = modifier.height(16.dp))

            if(!isSearching){
                LazyColumn {
                   items(gifs.itemCount){ index->
                       val item = gifs[index]
                       GifItem(
                           modifier = modifier.clickable {
                               onGifClicked(item?.gifId?:"")
                           },
                           imageUrl = item?.imageUrl ?:"",
                           imageLoader = imageLoader
                       )
                   }
                }
            } else {
                CircularProgressIndicator()
            }
        }
    }
}




@Composable
fun GifItem(
    modifier: Modifier,
    imageUrl:String,
    imageLoader:ImageLoader
){
    AsyncImage(
        model = imageUrl, contentDescription = "small gif",
        modifier = modifier,
        imageLoader = imageLoader
    )
}