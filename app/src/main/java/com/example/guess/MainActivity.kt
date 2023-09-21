package com.example.guess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.guess.ui.theme.GuessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}
var random=0
var trynum=0
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Number Guessing Game",
            modifier = modifier
        )
        Text(
            text = "Try to guess number 1-100",
            modifier = modifier
        )
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Your guess") }
        )
        var Hint by remember { mutableStateOf("") }
        Text(
            text = Hint,
            modifier = modifier
        )
        var Butt by remember { mutableStateOf("Play") }
        Button(onClick = {
            if (Butt=="Send") {
                trynum+=1
                if (text.toInt() > random) {
                    Hint = text + " is highter than answer."
                } else if (text.toInt() < random) {
                    Hint = text + " is lower than answer."
                } else if (text.toInt() == random) {
                    Hint = text + " is answer, you try "+trynum+" time."
                    Butt = "Play again"
                    trynum=0
                }
                text=""
            }
            else {
                random=(1..100).random()
                Hint=""
                Butt="Send"
            }
        }) {
            Text(
                text = Butt,
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuessTheme {
        Greeting()
    }
}