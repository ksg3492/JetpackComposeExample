package com.sunggil.basicscodelab

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import com.sunggil.basicscodelab.ui.component.ArrowIconButton

@Composable
fun Greeting(name : String) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    //추가 하단영역
    val extraPadding by animateDpAsState(
        if (isExpanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 5.dp),
        color = Color.Transparent
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            backgroundColor = MaterialTheme.colors.primary,
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
            ) {

                Row(
                    //padding 음수가 될 수 없음.
                    modifier = Modifier.padding(bottom = extraPadding.coerceAtLeast(0.dp))
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Hello,")
                        Text(text = "$name!")
                    }

                    IconButton(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight(),
                        onClick = { isExpanded = !isExpanded },
                    ) {
                        ArrowIconButton(
                            isExpanded = isExpanded,
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }

                //            Column(
                //                modifier = Modifier
                //                    .fillMaxWidth()
                //                    .wrapContentHeight(),
                //
                //            ) {
                //                Text(
                //                    text = "child ",
                //                    modifier = Modifier.padding(vertical = 24.dp)
                //                )
                //            }
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    Greeting("KSG")
}