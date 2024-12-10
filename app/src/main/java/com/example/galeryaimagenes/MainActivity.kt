package com.example.galeryaimagenes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeryaimagenes.ui.theme.GaleryaImagenesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleryaImagenesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageGallery(
                        modifier = Modifier.padding(innerPadding),
                        onImageClick = { imageTitle ->
                            Toast.makeText(this, " $imageTitle ", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ImageGallery(modifier: Modifier = Modifier, onImageClick: (String) -> Unit) {

    val images = listOf(
        Pair(R.drawable.vertex03, "Vertex 03"),
        Pair(R.drawable.vertex04, "Vertex 04"),
        Pair(R.drawable.viper, "Viper"),
        Pair(R.drawable.metalbone, "Metalbone"),
        Pair(R.drawable.essnovaltd, "Essnova LDT"),
        Pair(R.drawable.belav25, "Bela V2.5"),
        Pair(R.drawable.adipowermultiweight, "Adipower Multiweight"),
        Pair(R.drawable.ionicpower22, "Ionic Power 22"),
        Pair(R.drawable.matchlight, "Macht Light"),
        Pair(R.drawable.vortomsoftblue, "Vortom Soft Blue"),
        Pair(R.drawable.skypower, "Sky Power"),
        Pair(R.drawable.vertex02, "Vertex 02"),
        Pair(R.drawable.metalboneteamlight, "Metalbone Team Light")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(images) { (imageRes, title) ->
            ImageWithTitle(imageRes = imageRes, title = title, onClick = { onImageClick(title) })
        }
    }
}

@Composable
fun ImageWithTitle(imageRes: Int, title: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp)
        )
        Text(
            text = title,
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GaleryaImagenesTheme {
        ImageGallery(onImageClick = {})
    }
}