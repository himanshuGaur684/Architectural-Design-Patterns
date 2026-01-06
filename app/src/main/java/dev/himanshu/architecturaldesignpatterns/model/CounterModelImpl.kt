package dev.himanshu.architecturaldesignpatterns.model

import dev.himanshu.architecturaldesignpatterns.CounterContract

class CounterModelImpl : CounterContract.Model {

    private var counter: Int = 0

    override fun increment() {
        counter++
    }

    override fun decrement() {
        counter--
    }

    override fun getCounter(): Int {
        return counter
    }
}