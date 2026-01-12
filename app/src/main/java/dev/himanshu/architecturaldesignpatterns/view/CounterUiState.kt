package dev.himanshu.architecturaldesignpatterns.view

import androidx.compose.runtime.Immutable

@Immutable
data class CounterUiState(
    val counter: Int = 0
)
