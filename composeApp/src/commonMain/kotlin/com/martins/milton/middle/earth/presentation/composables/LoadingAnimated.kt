package com.martins.milton.middle.earth.presentation.composables

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import middle_earth.composeapp.generated.resources.Res
import middle_earth.composeapp.generated.resources.ic_ring
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoadingAnimated(modifier: Modifier) {
    val infiniteTransition = rememberInfiniteTransition()

    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Restart
        )
    )

    Image(
        painter = painterResource(Res.drawable.ic_ring),
        contentDescription = null,
        modifier = modifier
            .size(60.dp)
            .rotate(rotation)
    )
}