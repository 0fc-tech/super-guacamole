package com.example.mod4counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4counter.ui.theme.TPTheme
import com.example.mod4counter.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
                }
            }
        }
    }
}

@Composable
fun CounterScreen(vm: CounterViewModel = viewModel()) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text("${vm.counterState}",style =Typography.displayLarge)
        Row{
            Button(onClick = { vm.update(-10) }) {
                Text("-10")
            }
            FilledIconButton(onClick = { vm.update(-1) }) {
                Icon(imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Down")
            }
            FilledIconButton(onClick = { vm.update(1) }) {
                Icon(imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Up")
            }
            Button(onClick = { vm.update(10) }) {
                Text("+10")
            }
        }
    }
}