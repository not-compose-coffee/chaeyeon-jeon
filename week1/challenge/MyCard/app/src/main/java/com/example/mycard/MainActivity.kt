package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.dark_blue),
                ) {
                    MyCardScreen()
                }
            }
        }
    }
}

@Composable
fun MyCardScreen(
    modifier: Modifier = Modifier,
    phoneNumber: String = stringResource(R.string.main_dummy_phone_number),
    githubId: String = stringResource(R.string.main_dummy_github_id),
    email: String = stringResource(R.string.main_dummy_email),
) {
    Column(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            UserProfileCard()
        }
        Column(
            modifier = modifier
                .padding(bottom = 42.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
        ) {
            UserInfoItem(
                infoIcon = painterResource(R.drawable.ic_main_phone),
                infoText = phoneNumber,
            )
            UserInfoItem(
                infoIcon = painterResource(R.drawable.ic_main_code),
                infoText = githubId,
            )
            UserInfoItem(
                infoIcon = painterResource(R.drawable.ic_main_email),
                infoText = email,
            )
        }
    }
}

@Composable
fun UserProfileCard(
    name: String = stringResource(R.string.main_dummy_name),
    occupation: String = stringResource(R.string.main_dummy_occupation),
) {
    Image(
        modifier = Modifier
            .height(200.dp)
            .aspectRatio(1.0f),
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.main_profile_image_description),
    )
    Text(
        text = name,
        fontWeight = FontWeight.Light,
        fontSize = 32.sp,
        color = Color.White,
    )
    Text(
        modifier = Modifier
            .padding(top = 14.dp),
        text = occupation,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(id = R.color.green),
    )
}

@Composable
fun UserInfoItem(
    modifier: Modifier = Modifier,
    infoIcon: Painter,
    infoText: String,
) {
    Divider(
        color = colorResource(R.color.light_gray),
        thickness = 1.dp,
    )
    Row(
        modifier = modifier
            .padding(vertical = 9.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .padding(start = 40.dp),
            painter = infoIcon,
            contentDescription = stringResource(
                R.string.main_info_item_image_description,
                infoText,
            ),
        )
        Text(
            modifier = Modifier
                .padding(start = 22.dp),
            text = infoText,
            fontSize = 14.sp,
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyCardPreview() {
    MyCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.dark_blue),
        ) {
            MyCardScreen()
        }
    }
}
