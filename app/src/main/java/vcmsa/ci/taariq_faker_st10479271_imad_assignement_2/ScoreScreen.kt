package vcmsa.ci.taariq_faker_st10479271_imad_assignement_2

import android.os.Bundle
import android.view.View
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
        val questions = intent.getStringArrayExtra("Questions")
        val answers=intent.getBooleanArrayExtra("Answer")
        val userAnswers=intent.getBooleanArrayExtra("userAnswer")


        val reviewTextView=findViewById<TextView>(R.id.reviewTextView)
        val scoreText=findViewById<TextView>(R.id.scoreText)
        val feedbackTextView=findViewById<TextView>(R.id.feedbackText)
        val exitButton=findViewById<Button>(R.id.exitButton)
        val reviewButton=findViewById<Button>(R.id.reviewButton)



        scoreText.text="Score: $score out of $total"


        if (score >=3 ){
            feedbackTextView.text="Great Job!"
        }
        else{
            feedbackTextView.text="Keep Practising!"
        }

        exitButton.setOnClickListener {
            finish()

        }

        reviewButton.setOnClickListener {

            if ( questions!= null && answers!=null && userAnswers!=null){

                val reviewText=StringBuilder()
                for (i in questions.indices )
                {
                    reviewText.append("Q${i +1}: ${questions [i]} \n")
                    reviewText.append("Correct Answer: ${answers[i]}\n")
                    reviewText.append("Your Answer: ${userAnswers[i]}\n \n ")


                    scoreText.text=""
                    feedbackTextView.text=""

                }

                reviewTextView.text=reviewText.toString()
                reviewTextView.visibility= View.VISIBLE

            }



        }



        }
    }
