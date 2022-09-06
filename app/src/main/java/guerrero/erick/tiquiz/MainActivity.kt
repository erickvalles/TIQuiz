package guerrero.erick.tiquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import guerrero.erick.tiquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

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
        Log.d(TAG,"Se llamó al onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.questionTextView.setOnClickListener {
            updateQuestion()
        }

        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true,view)
        }

        binding.falseButton.setOnClickListener {view:View ->
            checkAnswer(false,view)
        }

        binding.nextButton.setOnClickListener { view:View->
            updateQuestion()
        }

        updateQuestion()

    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"OnStart llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"OnResume llamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"OnPause llamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"OnStop llamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"OnDestroy llamado")
    }


    private fun updateQuestion(){
        currentIndex = (currentIndex +1) % questionBank.size
        val questionIdRes = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionIdRes)
    }

    private fun checkAnswer(userAnswer:Boolean, view:View){
        val correctAnswer = questionBank[currentIndex].respuesta

        val mensaje = if(userAnswer == correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }

        val color = if(userAnswer == correctAnswer){
            R.color.verde
        }else{
            R.color.rojo
        }

        val snackBar = Snackbar.make(view,mensaje,Snackbar.LENGTH_LONG)
        snackBar.setBackgroundTint(getColor(color))
        snackBar.show()
    }
}