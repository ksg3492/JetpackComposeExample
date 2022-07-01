package com.sunggil.basicscodelab.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sunggil.basicscodelab.R

@Composable
fun ArrowIconButton(
    isExpanded : Boolean,
    contentDescription : String = "",
    colorFilter : ColorFilter? = null
) {
    val iconRes = if (isExpanded) {
        R.drawable.ic_baseline_keyboard_arrow_up_24
    } else {
        R.drawable.ic_baseline_keyboard_arrow_down_24
    }

    Image(
        painter = painterResource(iconRes),
        contentDescription = contentDescription,
        colorFilter = colorFilter
    )
}

@Preview
@Composable
fun IconButtonPreview() {
    Column(modifier = Modifier) {
        ArrowIconButton(true, colorFilter = ColorFilter.tint(Color.White))
        ArrowIconButton(false, colorFilter = ColorFilter.tint(Color.White))
    }
}