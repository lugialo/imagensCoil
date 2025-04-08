package com.example.imagenscoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.imagenscoil.ui.theme.ImagensCoilTheme
import org.jetbrains.annotations.Async

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        defineImage("https://i.pinimg.com/564x/33/0f/ff/330fffb3d3422820dc3b3591e5a90804.jpg", "Imagem do gato")
        defineImage("https://images.pexels.com/photos/1183099/pexels-photo-1183099.jpeg?cs=srgb&dl=pexels-simon73-1183099.jpg&fm=jpg", "Imagem da paisagem")
        defineImage("https://www1.satc.edu.br/portais/arquivos/usuarios/4124/598B663F-5586-4D8B-935A-4426883F44DB~2.jpg", "Imagem do professor")
        defineImage("https://cdn.techshake.com/imagens/magic-mouse-carregador-embaixo-do-mouse.jpg?class=article", "Imagem do pior mouse do mundo")
        defineImage("https://pbs.twimg.com/media/GLo5w9KWMAAx13r.jpg", "Bill Gates")
        defineImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl2fBN-xoyvWBXtqfjWq8Pn1fUOFp3j6z_Mw&s", "porquinho ui ui so chove")
    }

}

@Composable
fun defineImage(model: String, contentDescription: String)
{
    Spacer(modifier = Modifier.height(16.dp))
    AsyncImage(
        model = model,
        contentDescription = contentDescription
    )
}