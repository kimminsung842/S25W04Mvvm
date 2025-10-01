package kr.ac.kumoh.s20210181.s25w04mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
    //private val _counterState = mutableStateOf(CounterModel(0))
    private val _counterState = MutableStateFlow(CounterModel(0))
    //val counterState: State<CounterModel> = _counterState
    val counterState: StateFlow<CounterModel> = _counterState

    private val _events = MutableSharedFlow<String>()
    val events = _events.asSharedFlow()

//    fun setCounter(newValue: Int) {
//        _counterState.value = CounterModel(newValue)
//    }

    fun addCounter() {
        viewModelScope.launch {
            _counterState.value = CounterModel(_counterState.value.count + 1)
            if (_counterState.value.count == 5) {
                _events.emit("카운터 5에 도달")
            }
        }
    }

    fun subCounter() {
        _counterState.value = CounterModel(_counterState.value.count - 1)
    }

    fun resetCounter() {
        viewModelScope.launch {
            _counterState.value = CounterModel(0)
            _events.emit("카운터 초기화")
        }
    }
}