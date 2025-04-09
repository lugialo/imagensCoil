package com.example.imagenscoil
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
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
import coil.decode.SvgDecoder
import coil.request.ImageRequest
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
        DefineImage("https://i.pinimg.com/564x/33/0f/ff/330fffb3d3422820dc3b3591e5a90804.jpg", "Imagem do gato")
        DefineImage("https://images.pexels.com/photos/1183099/pexels-photo-1183099.jpeg?cs=srgb&dl=pexels-simon73-1183099.jpg&fm=jpg", "Imagem da paisagem")
        DefineImage("https://marsemfim.com.br/wp-content/uploads/2020/06/Akc-.jpg", "Imagem do Caranguejo")
        DefineImage("https://cdn.techshake.com/imagens/magic-mouse-carregador-embaixo-do-mouse.jpg?class=article", "Imagem do pior mouse do mundo")
        DefineImage("https://pbs.twimg.com/media/GLo5w9KWMAAx13r.jpg", "Bill Gates")
        DefineImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl2fBN-xoyvWBXtqfjWq8Pn1fUOFp3j6z_Mw&s", "porquinho ui ui so chove")
        DefineImage("https://media.tenor.com/rA1YEynAp2cAAAAM/bird-birb.gif","Trinca ferro")
        DefineImage("https://media.printables.com/media/prints/1224224/images/9178270_c3f5024a-ea2c-4655-a0fb-f4e0bf256783_10cf6be6-8ee2-43dd-b95e-82514e0f301c/thumbs/cover/800x800/jpeg/img_4257.jpg", "porco dio y porco ala")
        DefineImage("https://pbs.twimg.com/media/EygPCB1WQAErZF5?format=jpg&name=small","los mejores turn down for what 2010")
        DefineImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjYw14EjdBueosPjrz67bZM67cODNI0PJfwQ&s", "maizena")
        DefineImage("https://www.variboo.com.br/mensagens-de-bom-dia/wp-content/uploads/2021/01/gif-bom-dia-chuva-de-carinho.gif","bom dia")
        DefineImage("https://www.svgrepo.com/show/535115/alien.svg", "alien svg")
    }

}

@Composable
fun DefineImage(model: String, contentDescription: String) {
    Spacer(modifier = Modifier.height(16.dp))

    // Criação do ImageLoader com suporte para gifs e SVG
    val gifEnabledLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if ( SDK_INT >= 28 ) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
            add(SvgDecoder.Factory())


        }.build()

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(model)
            .build(),
        contentDescription = contentDescription,
        imageLoader = gifEnabledLoader
    )
}