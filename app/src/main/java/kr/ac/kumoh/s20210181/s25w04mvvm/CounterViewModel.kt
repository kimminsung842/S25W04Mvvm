package kr.ac.kumoh.s20210181.s25w04mvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counterState = mutableStateOf(CounterModel(0))
    val counterState: State<CounterModel> = _counterState

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