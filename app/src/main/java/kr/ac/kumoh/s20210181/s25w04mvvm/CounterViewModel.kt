package kr.ac.kumoh.s20210181.s25w04mvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel : ViewModel() {
    //private val _counterState = mutableStateOf(CounterModel(0))
    private val _counterState = MutableStateFlow(CounterModel(0))
    //val counterState: State<CounterModel> = _counterState
    val counterState: StateFlow<CounterModel> = _counterState

//    fun setCounter(newValue: Int) {
//        _counterState.value = CounterModel(newValue)
//    }

    fun addCounter() {
        _counterState.value = CounterModel(_counterState.value.count + 1)
    }

    fun subCounter() {
        _counterState.value = CounterModel(_counterState.value.count - 1)
    }

    fun resetCounter() {
        _counterState.value = CounterModel(0)
    }
}