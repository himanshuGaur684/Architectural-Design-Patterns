package dev.himanshu.architecturaldesignpatterns

interface CounterContract {

    interface View {
        fun showCounter(counter: Int)
    }

    interface Model {
        fun incrementCounter()
        fun decrementCounter()
        fun getCounter(): Int
    }

    interface Presenter {

        fun attach(view: View)
        fun detach()

        fun onIncrementClicked()
        fun onDecrementClicked()
    }
}
