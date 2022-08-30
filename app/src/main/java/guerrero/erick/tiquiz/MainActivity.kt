package guerrero.erick.tiquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import guerrero.erick.tiquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val questionBank = listOf(
        Question(R.string.question_cpu,false),
        Question(R.string.question_gpu,false),
        Question(R.string.question_ssh, true),
        Question(R.string.question_keyboard, true)
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.trueButton.setOnClickListener { view: View ->
            //Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show()
            val snackBar = Snackbar.make(view,R.string.correct_toast,Snackbar.LENGTH_LONG)
            snackBar.setBackgroundTint(resources.getColor(R.color.verde))
            snackBar.show()
        }

        binding.falseButton.setOnClickListener {view:View ->
            Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
        }

        val questionIdRes = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionIdRes)

    }
}