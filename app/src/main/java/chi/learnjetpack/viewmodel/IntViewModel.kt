package chi.learnjetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class IntViewModel(var number: Int = 0) : ViewModel()

class IntViewModelFactory(private val number: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return IntViewModel(number) as T
    }
}