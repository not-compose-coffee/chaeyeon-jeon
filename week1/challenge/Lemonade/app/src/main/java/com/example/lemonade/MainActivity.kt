package com.example.lemonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeScreen()
            }
        }
    }
}

@Composable
fun LemonadeScreen(modifier: Modifier = Modifier) {
    val lemonadeStep = remember { mutableStateOf(1) }
    val squeezeCount = remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = getLemonadeDescription(lemonadeStep.value),
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier
                .clickable {
                    when (lemonadeStep.value) {
                        1 -> {
                            squeezeCount.value = (1..5).random()
                            lemonadeStep.value++
                        }
                        2 -> {
                            Log.d("SQUEEZE", "$squeezeCount")
                            if (squeezeCount.value > 0) {
                                squeezeCount.value--
                                return@clickable
                            }
                            lemonadeStep.value++
                        }
                        3 -> lemonadeStep.value++
                        else -> lemonadeStep.value = 1
                    }
                }
                .border(
                    border = BorderStroke(2.dp, colorResource(R.color.light_blue)),
                    shape = RoundedCornerShape(4.dp),
                ),
            painter = getLemonadePainter(lemonadeStep.value),
            contentDescription = getLemonadeContentDescription(lemonadeStep.value),
        )
    }
}

@Composable
fun getLemonadeDescription(step: Int): String {
    return when (step) {
        1 -> stringResource(id = R.string.main_lemon_tree_description)
        2 -> stringResource(id = R.string.main_lemon_description)
        3 -> stringResource(id = R.string.main_glass_of_lemonade_description)
        else -> stringResource(id = R.string.main_empty_glass_description)
    }
}

@Composable
fun getLemonadePainter(step: Int): Painter {
    return when (step) {
        1 -> painterResource(id = R.drawable.lemon_tree)
        2 -> painterResource(id = R.drawable.lemon_squeeze)
        3 -> painterResource(id = R.drawable.lemon_drink)
        else -> painterResource(id = R.drawable.lemon_restart)
    }
}

@Composable
fun getLemonadeContentDescription(step: Int): String {
    return when (step) {
        1 -> stringResource(id = R.string.main_lemon_tree_content_description)
        2 -> stringResource(id = R.string.main_lemon_content_description)
        3 -> stringResource(id = R.string.main_glass_of_lemonade_content_description)
        else -> stringResource(id = R.string.main_empty_glass_content_description)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            LemonadeScreen()
        }
    }
}
