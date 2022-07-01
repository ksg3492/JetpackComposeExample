package com.sunggil.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sunggil.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        color = MaterialTheme.colors.background,
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Greeting("Android")

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name : String) {
    val isExpanded = remember { mutableStateOf(false) }
    //추가 하단영역
    val extraPadding = if (isExpanded.value) 48.dp else 0.dp

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        color = MaterialTheme.colors.primary,
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Row(
                modifier = Modifier.padding(bottom = extraPadding)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Hello,")
                    Text(text = "$name!")
                }

                OutlinedButton(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentSize(),
                    onClick = { isExpanded.value = !isExpanded.value },
                ) {
                    Text(if (isExpanded.value) "Show Less" else "Show More")
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

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}