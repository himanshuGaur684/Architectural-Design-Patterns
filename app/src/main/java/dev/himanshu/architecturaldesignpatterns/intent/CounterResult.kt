package dev.himanshu.architecturaldesignpatterns.intent

sealed interface CounterResult {
    data class CounterUpdated(val value: Int) : CounterResult
}