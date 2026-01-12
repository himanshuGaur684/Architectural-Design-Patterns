package dev.himanshu.architecturaldesignpatterns.model

class CounterModel {
    private var counter: Int = 0

    fun increment() {
        counter++
    }

    fun decrement() {
        counter--
    }

    fun getCounter() = counter
}