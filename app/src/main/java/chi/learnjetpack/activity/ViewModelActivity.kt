package chi.learnjetpack.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import chi.learnjetpack.R
import chi.learnjetpack.viewmodel.IntViewModel
import chi.learnjetpack.viewmodel.IntViewModelFactory
import kotlinx.android.synthetic.main.activity_view_model.*
import kotlin.random.Random

class ViewModelActivity : AppCompatActivity() {

    private lateinit var viewModel: IntViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        viewModel = ViewModelProvider(
            this,
            IntViewModelFactory(Random.nextInt())
        ).get(IntViewModel::class.java)
        showContent()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button -> {
                viewModel.number++
                showContent()
            }
        }
    }

    private fun showContent() {
        textView.text = viewModel.number.toString()
    }
}