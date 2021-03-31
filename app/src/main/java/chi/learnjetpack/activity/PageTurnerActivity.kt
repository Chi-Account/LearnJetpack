package chi.learnjetpack.activity

import android.os.Bundle
import chi.library.base.pageturner.BasePageTurnerActivity
import chi.library.base.pageturner.Page
import chi.library.util.LogUtil

class PageTurnerActivity : BasePageTurnerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.init(true)
    }

    override fun getPageList(): List<Page> =
        listOf(
            Page("ViewModel", ViewModelActivity::class.java),
            Page("Lifecycle", LifecycleActivity::class.java),
            Page("LiveData", LiveDataActivity::class.java)
        )
}