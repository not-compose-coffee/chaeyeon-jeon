package com.example.bithdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    // TODO: 실제 실행될 코드 추가
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(modifier: Modifier = Modifier, message: String) {
    Text(text = message)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BithdayCardTheme {
        BirthdayGreetingWithText(message = "생신 축하")
    }
}
