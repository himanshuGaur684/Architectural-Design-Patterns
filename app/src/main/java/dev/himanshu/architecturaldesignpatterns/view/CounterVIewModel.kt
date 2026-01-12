package dev.himanshu.architecturaldesignpatterns.view

import androidx.lifecycle.ViewModel
import dev.himanshu.architecturaldesignpatterns.intent.CounterAction
import dev.himanshu.architecturaldesignpatterns.intent.CounterIntent
import dev.himanshu.architecturaldesignpatterns.intent.CounterResult
import dev.himanshu.architecturaldesignpatterns.model.CounterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterVIewModel : ViewModel() {

    private val counterModel = CounterModel()

    private val _uiState = MutableStateFlow<CounterState>(CounterState())
    val uiState = _uiState.asStateFlow()

    fun onIntent(intent: CounterIntent) {
        when (intent) {
            CounterIntent.Decrement -> handleAction(CounterAction.DecrementClicked)
            CounterIntent.Increment -> handleAction(CounterAction.IncrementClicked)
        }
    }

    fun handleAction(action: CounterAction) {
        when (action) {
            CounterAction.DecrementClicked -> {
                counterModel.decrement()
                reduce(CounterResult.CounterUpdated(counterModel.getCounter()))
            }

            CounterAction.IncrementClicked -> {
                counterModel.increment()
                reduce(CounterResult.CounterUpdated(counterModel.getCounter()))
            }
        }
    }

    private fun reduce(result: CounterResult) {
        when (result) {
            is CounterResult.CounterUpdated -> {
                _uiState.update { it.copy(counter = result.value) }
            }
        }
    }

}