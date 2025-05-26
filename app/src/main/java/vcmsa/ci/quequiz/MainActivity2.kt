package vcmsa.ci.quequiz

import android.content.Intent
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    //Create an array of history questions
        val questions = arrayOf(
            "Did the great depression transform the lives?",
            "Did the cold war start in 1974 and  ended in 1990?",
            "Was South Africa colonised by the German?",
            "Did the 9/11 happen in september 11,2001",
            "Did the apartheid start in 1948?"
        )
        // Create an array of answers of (True or False) for the questions
        val answers = arrayOf("True", "False", "False", "True", "True")
        // This will track which questions we're on
        var currentIndex = 0
        // Track the user's score
        var score = 0
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // set the layout for the quiz screen
            setContentView(R.layout.activity_main2)
            // find all the views by their ids
            val questionText = findViewById<TextView>(R.id.QuestionTextView)
            val trueButton = findViewById<Button>(R.id.Truebutton)
            val falseButton = findViewById<Button>(R.id.Falsebutton)
            val feedbackText = findViewById<TextView>(R.id.FeedbacktextView)
            val nextbutton = findViewById<Button>(R.id.Nextbutton)
            // Display the first question
            questionText.text = questions[currentIndex]
            // What happens when the user clicks "True"
            trueButton.setOnClickListener{
                if(answers[currentIndex] == "True") {
                // Correct answer
                feedbackText.text = "Correct!"
                score++// Add 1 to score
            }else{
                // wrong answer
                feedbackText.text = "Incorrect!"

             }
            // what happens when the user clicks "False"
            falseButton.setOnClickListener{
                if(answers[currentIndex] == "False") {
                    feedbackText.text = "Correct!"
                    score++
                }else{
                    feedbackText.text = "Incorrect!"
                }
            }
            // move to the next question when "Next" is clicked
            nextbutton.setOnClickListener {
                currentIndex++
            }
                // Move to the next index in the array
                if (currentIndex < questions.size) {
                    // if there are more questions, display the next one
                    questionText.text = questions[currentIndex]
                    feedbackText.text = ""
                }else{
                    val intent = Intent(this, MainActivity3::class.java)
                    //Pass final score to the next screen
                    intent.putExtra("score",score)
                    //Pass array to the next screen
                    intent.putExtra("questions", questions)
                    intent.putExtra("answers",answers)
                    startActivity(intent)
                    finish()
                }
        }
    }
}