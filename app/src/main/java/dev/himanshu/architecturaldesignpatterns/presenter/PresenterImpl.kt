package dev.himanshu.architecturaldesignpatterns.presenter

import dev.himanshu.architecturaldesignpatterns.CounterContract

class PresenterImpl(
    private val model: CounterContract.Model
) : CounterContract.Presenter {

    private var view: CounterContract.View? = null

    override fun attach(view: CounterContract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    override fun onIncrementClicked() {
        model.incrementCounter()
        view?.showCounter(model.getCounter())
    }

    override fun onDecrementClicked() {
        model.decrementCounter()
        view?.showCounter(model.getCounter())
    }
}