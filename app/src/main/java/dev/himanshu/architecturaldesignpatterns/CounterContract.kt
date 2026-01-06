package dev.himanshu.architecturaldesignpatterns

interface CounterContract {

    interface View {
        fun showCounter(counter: Int)
    }

    interface Model {
        fun increment()
        fun decrement()
        fun getCounter(): Int
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()

        fun onIncrementClicked()
        fun onDecrementClicked()
    }

}