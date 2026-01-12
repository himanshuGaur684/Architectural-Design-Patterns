package dev.himanshu.architecturaldesignpatterns.view

import androidx.compose.runtime.Immutable

@Immutable
data class CounterState(
    val counter: Int = 0
)
