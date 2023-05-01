package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    val diceResult = remember { mutableStateOf(1) }
    val imageResource = when (diceResult.value) {
        1 -> R.drawable.img_main_dice_1
        2 -> R.drawable.img_main_dice_2
        3 -> R.drawable.img_main_dice_3
        4 -> R.drawable.img_main_dice_4
        5 -> R.drawable.img_main_dice_5
        else -> R.drawable.img_main_dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(
                R.string.main_dice_img_content_description,
                diceResult.value,
            ),
        )
        Spacer(
            modifier = Modifier.height(16.dp),
        )
        Button(onClick = { diceResult.value = (1..6).random() }) {
            Text(text = stringResource(R.string.main_roll))
        }
    }
}
