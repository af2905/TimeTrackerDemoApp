package com.github.af2905.timetrackerdemoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.af2905.timetracker.TimeTracker
import com.github.af2905.timetrackerdemoapp.ui.theme.TimeTrackerDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable tracking
        TimeTracker.isEnabled = BuildConfig.DEBUG
        TimeTracker.logger = { tag, msg -> Log.d(tag, msg) }

        // Measure screen setup
        TimeTracker.measure("MainScreenSetup") {
            enableEdgeToEdge()
            setContent {
                TimeTrackerDemoAppTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TimeTrackerDemoAppTheme {
        Greeting("Android")
    }
}