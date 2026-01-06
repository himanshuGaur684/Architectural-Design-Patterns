package dev.himanshu.architecturaldesignpatterns.presenter

import dev.himanshu.architecturaldesignpatterns.model.CounterModelImpl

object PresenterFactory {
    fun produce() = Presenter(model = CounterModelImpl())
}