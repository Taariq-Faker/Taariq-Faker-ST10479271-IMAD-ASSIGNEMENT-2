package vcmsa.ci.taariq_faker_st10479271_imad_assignement_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton=findViewById<Button>(R.id.startButton)


        //Initializing the process which will begin once the start button is clicked
        startButton.setOnClickListener {

            //creating a explicit intent in order to connect the welcome screen to the flash card screen
        val intent=Intent(this,FlashcardQuestionScreen::class.java)


        //starting the activity once the button is clicked
        startActivity(intent)



        }








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}