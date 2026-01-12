package dev.himanshu.architecturaldesignpatterns.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.himanshu.architecturaldesignpatterns.intent.CounterIntent
import dev.himanshu.architecturaldesignpatterns.view.ui.theme.ArchitecturalDesignPatternsTheme

class MainActivity : ComponentActivity() {

    private val viewmodel: CounterVIewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArchitecturalDesignPatternsTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    val uiState by viewmodel.uiState.collectAsStateWithLifecycle()
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(uiState.counter.toString())

                        Spacer(Modifier.height(12.dp))

                        Button(onClick = { viewmodel.onIntent(CounterIntent.Increment) }
                        ) { Text("Increment") }

                        Spacer(Modifier.height(12.dp))

                        Button(
                            onClick = { viewmodel.onIntent(CounterIntent.Decrement) }
                        ) { Text("Decrement") }

                    }
                }
            }
        }
    }
}