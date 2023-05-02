package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.main_text_composable_title),
                description = stringResource(R.string.main_text_composable_description),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f),
            )
            ComposableInfoCard(
                title = stringResource(R.string.main_image_composable_title),
                description = stringResource(R.string.main_image_composable_description),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f),
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.main_row_composable_title),
                description = stringResource(R.string.main_row_composable_description),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f),
            )
            ComposableInfoCard(
                title = stringResource(R.string.main_column_composable_title),
                description = stringResource(R.string.main_column_composable_description),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = CenterHorizontally)
                .padding(bottom = 16.dp),
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
        )
    }
}