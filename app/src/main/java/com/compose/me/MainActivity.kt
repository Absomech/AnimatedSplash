package com.compose.me

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.me.ui.theme.AnimatedSplashTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedSplashTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    initComponent()
                    bindSplash()
                }
            }
        }
    }

    fun enterHome() {
        val intent = Intent(applicationContext, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun bindSplash() {
        var count = 0
        object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                count += 1
                Log.d("COMPOSE_CODE" , "Count : $count")
                if (count == 7) {
                    cancel()
                    onFinish()
                }
            }

            override fun onFinish() {
                enterHome()

            }

        }.start()
    }
}

@Composable
fun initComponent(){
    Box(modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.align(Alignment.Center)) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "Splash Logo",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .size(150.dp, 150.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Learn Compose",
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 30.sp,
                color = Color(0xFFC40C0C)

            )
            Text(text = "Make a connection to learn new things",
                modifier = Modifier.align(CenterHorizontally)
            )


        }

        CircularProgressIndicator(
            color = Color(0xFFC40C0C),
            modifier =
            Modifier
                .padding(20.dp)
                .align(BottomCenter)
                .size(50.dp)
        )
    }




}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimatedSplashTheme {
        initComponent()
    }
}