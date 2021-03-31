package chi.learnjetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ActivityObserver(
    private val lifecycle: Lifecycle
) : LifecycleObserver {

    companion object {
        private const val TAG = "ActivityObserver"
    }

    /**
     * 通过注解监听对应的生命周期方法
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(TAG, "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(TAG, "onStop")
    }

    /**
     * 通过 Lifecycle 对象的 getCurrentState() 主动获取当前的声明周期状态
     */
    fun getCurrentState(): String = when (lifecycle.currentState) {
        Lifecycle.State.INITIALIZED -> "Initialized"
        Lifecycle.State.CREATED -> "Created"
        Lifecycle.State.STARTED -> "Started"
        Lifecycle.State.RESUMED -> "Resumed"
        Lifecycle.State.DESTROYED -> "Destroyed"
        else -> "Other"
    }
}