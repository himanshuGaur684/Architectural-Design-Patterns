package dev.himanshu.architecturaldesignpatterns.view

import androidx.lifecycle.ViewModel
import dev.himanshu.architecturaldesignpatterns.intent.CounterAction
import dev.himanshu.architecturaldesignpatterns.intent.CounterIntent
import dev.himanshu.architecturaldesignpatterns.intent.CounterResult
import dev.himanshu.architecturaldesignpatterns.model.CounterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private val counterModel = CounterModel()

    private val _uiState = MutableStateFlow<CounterUiState>(CounterUiState())
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
                reduce(CounterResult.UpdatedCounter(counter = counterModel.getCounter()))
            }

            CounterAction.IncrementClicked -> {
                counterModel.increment()
                reduce(CounterResult.UpdatedCounter(counter = counterModel.getCounter()))
            }
        }
    }

    fun reduce(result: CounterResult) {
        when (result) {
            is CounterResult.UpdatedCounter -> {
                _uiState.update { it.copy(counter = result.counter) }
            }
        }
    }


}