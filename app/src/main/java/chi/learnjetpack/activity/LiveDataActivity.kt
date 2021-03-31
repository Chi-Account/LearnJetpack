package chi.learnjetpack.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import chi.learnjetpack.R
import chi.learnjetpack.livedata.UserViewModel
import kotlinx.android.synthetic.main.activity_live_data.*
import kotlin.random.Random

class LiveDataActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.nameLiveData.observe(this) { name ->
            tvName.text = name
        }
        viewModel.ageLiveData.observe(this) { age ->
            tvAge.text = age.toString()
        }
        viewModel.userLiveData.observe(this) { user ->
            tvUser.text = "${user.name} ${user.age}"
        }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button -> {
                viewModel.updateUser("张智琦${Random.nextInt(10)}")
            }
        }
    }
}