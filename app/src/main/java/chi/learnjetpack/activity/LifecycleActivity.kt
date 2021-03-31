package chi.learnjetpack.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import chi.learnjetpack.R
import chi.learnjetpack.lifecycle.ActivityObserver

class LifecycleActivity : AppCompatActivity() {

    lateinit var observer: ActivityObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        observer = ActivityObserver(lifecycle)
        lifecycle.addObserver(observer)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(observer)
    }
}