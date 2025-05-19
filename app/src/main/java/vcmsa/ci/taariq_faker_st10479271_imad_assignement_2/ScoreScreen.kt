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

        //Retrieving the score,total,questions,answers and user answers to the flash card question screen
        val score=intent.getIntExtra("score",0)
        val total=intent.getIntExtra("total",0)
        val questions = intent.getStringArrayExtra("Questions")
        val answers=intent.getBooleanArrayExtra("Answer")
        val userAnswers=intent.getBooleanArrayExtra("userAnswer")

        //Defining the buttons and textview so that it is accessible in the program by referencing their ids form the layout
        val reviewTextView=findViewById<TextView>(R.id.reviewTextView)
        val scoreText=findViewById<TextView>(R.id.scoreText)
        val feedbackTextView=findViewById<TextView>(R.id.feedbackText)
        val exitButton=findViewById<Button>(R.id.exitButton)
        val reviewButton=findViewById<Button>(R.id.reviewButton)
        val scoreButton=findViewById<Button>(R.id.scoreButton)


        //Displaying the users score
        scoreText.text="Score: $score out of $total"

        //Using if statements to display feedback based on the users score
        if (score >=3 ){
            feedbackTextView.text="Great Job!"
        }
        else{
            feedbackTextView.text="Keep Practising!"
        }

        //Programming the exit button
        exitButton.setOnClickListener {
            //Closing the activity once the button is clicked
            finishAffinity()

        }

        //Programming the Review button
        reviewButton.setOnClickListener {

            //Making sure all the arrays are not null before accessing them
            if ( questions!= null && answers!=null && userAnswers!=null){

                //Creating a string builder to build the review text
                val reviewText=StringBuilder()

                //Uisng a loop to loop through all the questions and add the information to the review
                for (i in questions.indices )
                {
                    reviewText.append(" ${questions [i]} \n")
                    reviewText.append("Correct Answer: ${answers[i]}\n")
                    reviewText.append("Your Answer: ${userAnswers[i]}\n \n ")


                    //Clearing the score and feedback when showing the review
                    scoreText.text=""
                    feedbackTextView.text=""

                }

                //Displaying the review
                reviewTextView.text=reviewText.toString()
                reviewTextView.visibility= View.VISIBLE

            }
        }

        //Coding the score Button
        scoreButton.setOnClickListener {

            //Clearing the review when showing the score and Feedback
            reviewTextView.text=""

            //Showing the score and feedback once again
            scoreText.text="Score: $score out of $total"
            if (score >=3 ){
                feedbackTextView.text="Great Job!"
            }
            else{
                feedbackTextView.text="Keep Practising!"
            }

        }

        }
    }
