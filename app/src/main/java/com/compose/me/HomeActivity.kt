package com.compose.me

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.compose.me.ui.theme.AnimatedSplashTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedSplashTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("HomeActivity")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            color = Color(0xFFC40C0C),
            fontSize = 30.sp,
            text = "$name",
            modifier = Modifier.align(Alignment.Center)

        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AnimatedSplashTheme {
        Greeting2("Android")
    }
}