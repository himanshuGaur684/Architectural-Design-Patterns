package dev.himanshu.architecturaldesignpatterns.model

import dev.himanshu.architecturaldesignpatterns.CounterContract

class CounterModelImpl : CounterContract.Model {
    private var counter: Int = 0
    override fun incrementCounter() {
        this.counter++
    }

    override fun decrementCounter() {
        this.counter--
    }

    override fun getCounter(): Int = counter
}