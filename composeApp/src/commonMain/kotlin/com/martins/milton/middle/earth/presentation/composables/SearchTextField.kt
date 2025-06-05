package com.martins.milton.middle.earth.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.martins.milton.middle.earth.common.useDebounce
import com.martins.milton.middle.earth.theming.DefaultElevation
import com.martins.milton.middle.earth.theming.DefaultInputFontSize
import com.martins.milton.middle.earth.theming.MediumSpacing
import middle_earth.composeapp.generated.resources.Res
import middle_earth.composeapp.generated.resources.action_clear
import middle_earth.composeapp.generated.resources.action_search
import org.jetbrains.compose.resources.stringResource

@Composable
fun SearchTextField(
    hint: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    cornerShape: Shape = RoundedCornerShape(MediumSpacing),
    onTextChange: (String) -> Unit = {}
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue()) }

    textFieldValue.useDebounce {
        onTextChange(it.text)
    }

    Row(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .padding(MediumSpacing)
            .shadow(
                elevation = DefaultElevation,
                shape = cornerShape
            )
            .background(
                color = MaterialTheme.colors.onPrimary,
                shape = cornerShape
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = modifier.weight(5f),
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
            },
            enabled = isEnabled,
            textStyle = TextStyle(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = DefaultInputFontSize
            ),
            decorationBox = { innerTextField ->
                if (textFieldValue.text.isEmpty()) {
                    Text(
                        modifier = Modifier
                            .weight(5f)
                            .padding(MediumSpacing),
                        text = hint,
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = DefaultInputFontSize
                    )
                }
                innerTextField()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true
        )
        Box(
            modifier = modifier
                .size(50.dp)
                .background(
                    color = Color.Transparent,
                    shape = CircleShape
                )
                .clickable {
                    if (textFieldValue.text.isNotEmpty()) {
                        textFieldValue = TextFieldValue(text = "")
                    }
                }
        ) {
            if (textFieldValue.text.isNotEmpty()) {
                Icon(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(MediumSpacing),
                    imageVector = Icons.Default.Clear,
                    contentDescription = stringResource(Res.string.action_clear),
                    tint = MaterialTheme.colors.primary
                )
            } else {
                Icon(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(MediumSpacing),
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(Res.string.action_search),
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    }
}