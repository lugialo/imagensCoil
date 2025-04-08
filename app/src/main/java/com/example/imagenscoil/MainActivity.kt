package com.example.imagenscoil

import android.os.Build.VERSION.SDK_INT
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
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
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
        defineImage("https://marsemfim.com.br/wp-content/uploads/2020/06/Akc-.jpg", "Imagem do Caranguejo")
        defineImage("https://cdn.techshake.com/imagens/magic-mouse-carregador-embaixo-do-mouse.jpg?class=article", "Imagem do pior mouse do mundo")
        defineImage("https://pbs.twimg.com/media/GLo5w9KWMAAx13r.jpg", "Bill Gates")
        defineImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl2fBN-xoyvWBXtqfjWq8Pn1fUOFp3j6z_Mw&s", "porquinho ui ui so chove")
        defineImage("https://media.tenor.com/rA1YEynAp2cAAAAM/bird-birb.gif","Trinca ferro")
        defineImage("https://media.printables.com/media/prints/1224224/images/9178270_c3f5024a-ea2c-4655-a0fb-f4e0bf256783_10cf6be6-8ee2-43dd-b95e-82514e0f301c/thumbs/cover/800x800/jpeg/img_4257.jpg", "porco dio y porco ala")
        defineImage("https://pbs.twimg.com/media/EygPCB1WQAErZF5?format=jpg&name=small","los mejores turn down for what 2010")
        defineImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjYw14EjdBueosPjrz67bZM67cODNI0PJfwQ&s", "maizena")
        defineImage("https://www.variboo.com.br/mensagens-de-bom-dia/wp-content/uploads/2021/01/gif-bom-dia-chuva-de-carinho.gif","bom dia")
    }

}

@Composable
fun defineImage(model: String, contentDescription: String) {
    Spacer(modifier = Modifier.height(16.dp))

    val gifEnabledLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if ( SDK_INT >= 28 ) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()

    // Criação do ImageLoader com suporte para GIFs
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .crossfade(true)
        .build()

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(model)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        imageLoader = gifEnabledLoader
    )
}