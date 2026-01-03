package dev.himanshu.architecturaldesignpatterns.controller

import dev.himanshu.architecturaldesignpatterns.model.CounterModel
import dev.himanshu.architecturaldesignpatterns.view.CounterView

class CounterControllerImpl(
    private val model: CounterModel,
    private val view: CounterView
) : CounterController {
    override fun onIncrementClicked() {
        model.increment()
        view.showCounter(model.getCounter())
    }

    override fun onDecrementClicked() {
        model.decrement()
        view.showCounter(model.getCounter())
    }
}