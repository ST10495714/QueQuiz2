package vcmsa.ci.quequiz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for the score screen
        setContentView(R.layout.activity_main3)

        // Get the score passed from the activity
        val score = intent.getIntExtra("score", 0)
        // get arrays passed from the activity
        val answers = intent.getStringArrayExtra("answers")
        val questions = intent.getStringArrayExtra("questions")
        // Get views by Id
        val resultText = findViewById<TextView>(R.id.ScoretextView)
        val reviewButton = findViewById<Button>(R.id.ReviewScorebutton)
        val exitButton = findViewById<Button>(R.id.Exitbutton)
        // Create feedback message based on how well the user did
        val message = when (score) {
            5 -> "Excellent!"
            in 3..4 -> "Well Done!"
            else -> "Keep trying!"
        }
        //Show the users final score and feedback massage
        resultText.text = "You scored $score out of 5\n$message"
        reviewButton.setOnClickListener {
            val reviewText = StringBuilder()
            if (questions != null && answers != null) {
                // loop through question and answers for
                for (i in questions.indices) {
                    reviewText.append("Q${i + 1}:${questions[i]}\n")
                    reviewText.append("Answer:${answers[i]}\n\n")
                }
                // Display in an alert dialog
                AlertDialog.Builder(this)
                    .setTitle("Review QueQuize")
                    .setMessage(reviewText.toString())
                    .setPositiveButton("Ouhk", null)
                    .show()
            } else {
                Toast.makeText(this, "No review data available.", Toast.LENGTH_SHORT).show()
            }
        }
        //Exit the app completely when exit button is clicked
        exitButton.setOnClickListener {
            finishAffinity()
        }
        //closes all app activities
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}