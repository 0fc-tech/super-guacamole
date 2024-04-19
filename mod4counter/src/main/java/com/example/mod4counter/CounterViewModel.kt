package com.example.mod4counter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var counterState by mutableIntStateOf(0)
        private set

    fun update(incBy: Int) {
        counterState += incBy
    }
}