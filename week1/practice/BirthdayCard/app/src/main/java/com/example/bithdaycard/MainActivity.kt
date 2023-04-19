package com.example.bithdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bithdaycard.ui.theme.BithdayCardTheme

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
    Column(modifier = modifier) {
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
    Image(
        painter = birthdayImage,
        contentDescription = null,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BithdayCardTheme {
        BirthdayGreetingWithImage(message = "생신 축하", from = "광렬")
    }
}
