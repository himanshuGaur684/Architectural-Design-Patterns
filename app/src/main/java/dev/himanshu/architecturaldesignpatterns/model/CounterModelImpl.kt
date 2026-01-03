package dev.himanshu.architecturaldesignpatterns.model

class CounterModelImpl : CounterModel {

    private var counter: Int = 0

    override fun increment() {
        counter++
    }

    override fun decrement() {
        counter--
    }

    override fun getCounter(): Int = counter

}