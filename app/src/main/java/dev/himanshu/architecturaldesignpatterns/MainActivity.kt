package dev.himanshu.architecturaldesignpatterns

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import dev.himanshu.architecturaldesignpatterns.presenter.PresenterFactory

class MainActivity : ComponentActivity(), CounterContract.View {

    private val presenter = PresenterFactory.produce()

    private val tvCounter: TextView by lazy { findViewById(R.id.tvCounter) }
    private val btnIncrement: Button by lazy { findViewById(R.id.btnIncrement) }
    private val btnDecrement: Button by lazy { findViewById(R.id.btnDecrement) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        presenter.attach(this)

        btnIncrement.setOnClickListener { presenter.onIncrementClicked() }
        btnDecrement.setOnClickListener { presenter.onDecrementClicked() }

    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showCounter(counter: Int) {
        tvCounter.text = counter.toString()
    }
}

