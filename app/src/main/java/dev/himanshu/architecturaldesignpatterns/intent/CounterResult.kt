package dev.himanshu.architecturaldesignpatterns.intent

sealed interface CounterResult {
    data class UpdatedCounter(val counter: Int) : CounterResult
}