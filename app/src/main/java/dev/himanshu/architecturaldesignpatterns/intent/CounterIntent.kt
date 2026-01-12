package dev.himanshu.architecturaldesignpatterns.intent

sealed interface CounterIntent {
    data object Increment : CounterIntent
    data object Decrement : CounterIntent
}