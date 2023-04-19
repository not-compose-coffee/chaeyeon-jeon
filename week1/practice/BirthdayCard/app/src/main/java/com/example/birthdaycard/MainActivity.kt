package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BithdayCardTheme
import com.example.bithdaycard.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BithdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    BirthdayGreetingWithImage(message = "생일 추카해", from = "광렬")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(modifier: Modifier = Modifier, message: String, from: String) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally,
    ) {
        Text(
            text = message,
            fontSize = 36.sp,
        )
        Text(
            text = "- from $from -",
            fontSize = 24.sp,
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(modifier: Modifier = Modifier, message: String, from: String) {
    val birthdayImage = painterResource(id = R.drawable.img_main_birthday_card)
    Box(modifier = modifier) {
        Image(
            painter = birthdayImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BithdayCardTheme {
        BirthdayGreetingWithImage(message = "생신 축하", from = "광렬")
    }
}
