package com.sunggil.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    //최초
    if (shouldShowOnboarding) {
        OnboardingScreen { shouldShowOnboarding = false }
    } else {
        GreetingScreen()
    }
}

@Composable
fun OnboardingScreen(onNextClicked : () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome to OnbardingScreen!")
            Button(
                //클릭 이벤트를 상위로 넘긴다.
                onClick = onNextClicked
            ) {
                Text("Next Screen")
            }
        }


    }
}

@Composable
fun GreetingScreen(datas : List<String> = List(1000) { "$it" }) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background,
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            items(items = datas) { name ->
                Greeting("Android $name")
            }
        }
    }

}

@Composable
fun Greeting(name : String) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    //추가 하단영역
    val extraPadding by animateDpAsState(
        if (isExpanded) 48.dp else 0.dp
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 5.dp),
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
                    onClick = { isExpanded = !isExpanded },
                ) {
                    Text(if (isExpanded) "Show Less" else "Show More")
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
fun MyAppPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        OnboardingScreen {}
    }
}