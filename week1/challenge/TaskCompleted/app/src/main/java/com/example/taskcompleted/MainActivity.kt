package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskCompletedScreen(
                Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
            )
        }
    }
}

@Composable
fun TaskCompletedScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = stringResource(R.string.main_task_completed_icon_content_description),
        )
        Text(
            text = "All tasks completed",
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp,
                )
                .align(Alignment.CenterHorizontally),
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCompletedScreen()
}
