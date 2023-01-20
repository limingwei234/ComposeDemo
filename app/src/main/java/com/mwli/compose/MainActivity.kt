package com.mwli.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.mwli.compose.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {

    Column() {
        Text(text = "Hello $name!", color = Color.Blue, style = TextStyle(fontSize = 10.sp))
        Text(text = "~~~~~~~~~~", color = Color.Red)
        Image(painter = painterResource(id = R.drawable.a), contentDescription = "", Modifier.size(
            Dp(160f), Dp(160f)))
//        Image(modifier = Modifier.size(100.dp, 100.dp), painter = pp, contentDescription = "")
        // http://pic-bucket.ws.126.net/photo/0003/2021-11-16/GOTKEOOU00AJ0003NOS.jpg
        AsyncImage(
            model = "https://img2.baidu.com/it/u=1395980100,2999837177&fm=253&app=120&size=w931&n=0&f=JPEG&fmt=auto?sec=1674320400&t=1a274b57153106011ffaca16127510d4",
            contentDescription = null,
            modifier = Modifier.size(100.dp, 100.dp).clip(CircleShape),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            onError = {
                it.result?.throwable?.message?.let { it1 -> Log.i("limingwei", it1) }
            },
            contentScale = ContentScale.Crop
        )
//
//        Image(painter = rememberAsyncImagePainter(model = "https://img2.baidu.com/it/u=1395980100,2999837177&fm=253&app=120&size=w931&n=0&f=JPEG&fmt=auto?sec=1674320400&t=1a274b57153106011ffaca16127510d4",),
//            contentDescription = null,
//            modifier = Modifier.clip(CircleShape))


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        Greeting("Android")
    }
}