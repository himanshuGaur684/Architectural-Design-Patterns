package dev.himanshu.architecturaldesignpatterns.presenter

import dev.himanshu.architecturaldesignpatterns.model.CounterModelImpl

object PresenterFactory {
    fun provide() = PresenterImpl(model = CounterModelImpl())
}