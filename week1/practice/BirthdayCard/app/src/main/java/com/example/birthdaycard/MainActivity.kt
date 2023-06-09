package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    BirthdayGreetingWithImage(
                        message = getString(R.string.main_greeting_msg),
                        from = getString(R.string.main_gwangryeol),
                    )
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
            modifier = Modifier
                .padding(top = 16.dp),
        )
        Text(
            text = stringResource(R.string.main_greeting_from_msg, from),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp),
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
        BirthdayGreetingWithImage(
            message = stringResource(R.string.main_greeting_msg),
            from = stringResource(R.string.main_gwangryeol),
        )
    }
}
