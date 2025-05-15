package vcmsa.ci.taariq_faker_st10479271_imad_assignement_2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val score=intent.getIntExtra("score",0)
        val total=intent.getIntExtra("total",0)
        val scoreText=findViewById<TextView>(R.id.scoreText)
        val feedbackText=findViewById<TextView>(R.id.feedbackText)
        val exitButton=findViewById<Button>(R.id.exitButton)
        val reviewButton=findViewById<Button>(R.id.reviewButton)
        val questions=intent.getIntExtra("Questons",0)
        val answer=intent.getIntExtra("Answer",0)


        scoreText.text="Score: $score out of $total"


        if (score >=3 ){
            feedbackText.text="Great Job!"
        }
        else{
            feedbackText.text="Keep Practising!"
        }

        exitButton.setOnClickListener {
            finish()

        }

        reviewButton.setOnClickListener {
            feedbackText.text=


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}