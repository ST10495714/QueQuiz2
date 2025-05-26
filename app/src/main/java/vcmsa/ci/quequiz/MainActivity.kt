package vcmsa.ci.quequiz

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the layout for this screen
        setContentView(R.layout.activity_main)

        // Get the start button using its ID
        val startButton = findViewById<Button>(R.id.Startbutton)
        // See what happens when the start button is clicked
        startButton.setOnClickListener {
            // create a new screen (intent)
            val intent = Intent(this, MainActivity2::class.java)
            // start the activity
            startActivity(intent)
        }
    }
}