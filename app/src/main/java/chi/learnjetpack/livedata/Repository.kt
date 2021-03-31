package chi.learnjetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

object Repository {

    fun getUserLiveData(name: String): LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(name, Random.nextInt(100))
        return liveData
    }
}