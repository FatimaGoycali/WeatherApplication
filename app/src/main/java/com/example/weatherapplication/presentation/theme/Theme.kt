package com.example.weatherapplication.presentation.theme


import Typographys
import androidx.compose.material.MaterialTheme

import androidx.compose.runtime.Composable


@Composable
fun WeatherApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = Typographys,
        shapes = Shapes,
        content = content
    )
}
