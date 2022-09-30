package com.example.test

import android.media.Image
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R.drawable
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayMainText(message = stringResource(id = R.string.happy), from = stringResource(
                        id = R.string.from
                    ))
                    BackWallImage()

                }
            }
        }
    }
}


@Composable
fun BirthdayMainText(message: String, from: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 50.dp)) {
        Text(text = message,
        fontSize = 35.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(text = from,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 16.dp))

    }

}

@Composable
fun BackWallImage(){
    val image = painterResource(id = drawable.androidparty)
    Box {
        Image(
            painter = painterResource(id = drawable.androidparty), contentDescription = "null",
            modifier = Modifier
                .fillMaxSize(), contentScale = ContentScale.Crop
        )
        BirthdayMainText(message = stringResource(id = R.string.happy), from = stringResource(id = R.string.from))
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    TestTheme {
        BirthdayMainText(message = stringResource(id = R.string.happy), from = stringResource(id = R.string.from))
        BackWallImage()
    }}
