package com.martins.milton.middle.earth.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.martins.milton.middle.earth.common.GenericCallback
import com.martins.milton.middle.earth.theming.LargeSpacing
import com.martins.milton.middle.earth.theming.MediumSpacing
import com.martins.milton.middle.earth.theming.SmallSpacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InfoItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    url: String? = null,
    onClick: GenericCallback<String> = {}
) {
    Card(
        modifier = modifier.padding(MediumSpacing),
        shape = RoundedCornerShape(SmallSpacing),
        onClick = { url?.let { onClick(it) } }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LargeSpacing),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = description,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}