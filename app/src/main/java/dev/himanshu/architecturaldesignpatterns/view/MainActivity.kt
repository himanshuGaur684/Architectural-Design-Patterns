package dev.himanshu.architecturaldesignpatterns.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import dev.himanshu.architecturaldesignpatterns.R
import dev.himanshu.architecturaldesignpatterns.controller.CounterController
import dev.himanshu.architecturaldesignpatterns.controller.CounterControllerImpl
import dev.himanshu.architecturaldesignpatterns.model.CounterModel
import dev.himanshu.architecturaldesignpatterns.model.CounterModelImpl

class MainActivity : ComponentActivity(), CounterView {

    // MVC
    private val model: CounterModel by lazy { CounterModelImpl() }
    private val controller: CounterController by lazy { CounterControllerImpl(model, this) }

    // Views
    private val text by lazy { findViewById<TextView>(R.id.counter) }
    private val incrementButton by lazy { findViewById<TextView>(R.id.increment) }
    private val decrementButton by lazy { findViewById<TextView>(R.id.decrement) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        incrementButton.setOnClickListener { controller.onIncrementClicked() }

        decrementButton.setOnClickListener { controller.onDecrementClicked() }
    }

    override fun showCounter(counter: Int) {
        text.text = counter.toString()
    }
}