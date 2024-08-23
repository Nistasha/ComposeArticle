package com.example.composearticle


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                ComposeArticleImage(message = stringResource(R.string.jetpack_compose_tutorial),
                    description = stringResource(R.string.description),
                    longDescription= stringResource(R.string.longDescription)
                )
                }
            }
        }
    }
}
@Composable
fun ComposeArticleImage(message: String, description: String, longDescription : String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(modifier = modifier){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
//            contentScale = ContentScale.Crop
        )
        ComposeArticleApp(
            message = message,
            description = description,
            longDescription = longDescription)
    }
}
@Composable
fun ComposeArticleApp(message: String, description: String, longDescription : String, modifier: Modifier = Modifier){
    Column (modifier = modifier){
        Text(
            text = message,
            modifier= Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = description,
            modifier= Modifier.padding(start = 16.dp, end= 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier= Modifier.padding(16.dp),
            textAlign = TextAlign.Justify)
    }

}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    ComposeArticleTheme {
        ComposeArticleImage(message = stringResource(R.string.jetpack_compose_tutorial),
            description = stringResource(R.string.description),
            longDescription= stringResource(R.string.longDescription)
        )
           }
}