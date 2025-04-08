package com.example.imagenscoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.imagenscoil.ui.theme.ImagensCoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowImages()
        }
    }
}


@Composable
@Preview
fun ShowImages()
{
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        AsyncImage(
            model = "https://i.pinimg.com/564x/33/0f/ff/330fffb3d3422820dc3b3591e5a90804.jpg",
            contentDescription = "Imagem do gato"
        )
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = "https://images.pexels.com/photos/1183099/pexels-photo-1183099.jpeg?cs=srgb&dl=pexels-simon73-1183099.jpg&fm=jpg",
            contentDescription = "GIF do gato",
        )
        Spacer(modifier = Modifier.height(16.dp))

    }


}