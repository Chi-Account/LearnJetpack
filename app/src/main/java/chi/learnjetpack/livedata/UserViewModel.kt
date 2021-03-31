package chi.learnjetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val rawNameLiveData = MutableLiveData<String>()

    val nameLiveData: LiveData<String>
        get() = rawNameLiveData

    val userLiveData: LiveData<User> = Transformations.switchMap(rawNameLiveData) { name ->
        Repository.getUserLiveData(name)
    }

    val ageLiveData: LiveData<Int> = Transformations.map(userLiveData) { user ->
        user.age
    }

    fun updateUser(name: String) {
        rawNameLiveData.value = name
    }
}