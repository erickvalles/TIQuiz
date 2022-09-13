package guerrero.erick.tiquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_cpu,false),
        Question(R.string.question_gpu,false),
        Question(R.string.question_ssh, true),
        Question(R.string.question_keyboard, true)
    )
    private var currentIndex = 0

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].respuesta
    val currentQuestionText : Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}