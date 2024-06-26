package com.example.view_model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.view_model.screen.CounterViewModel
import com.example.view_model.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelTheme {
                MyApp(viewModel)
            }
        }
    }
}

@Composable
fun MyApp(viewModel: CounterViewModel) {
    val counter = viewModel.counter.collectAsState()

    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = counter.value.toString(), style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.incrementCounter() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EA), // Color morado personalizado
                    contentColor = Color.White // Color del texto
                )
            ) {
                Text(text = "Incrementar")
            }
        }
    }
}