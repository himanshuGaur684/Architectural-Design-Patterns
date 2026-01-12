package dev.himanshu.architecturaldesignpatterns.intent

sealed interface CounterAction {
    data object IncrementClicked : CounterAction
    data object DecrementClicked : CounterAction
}