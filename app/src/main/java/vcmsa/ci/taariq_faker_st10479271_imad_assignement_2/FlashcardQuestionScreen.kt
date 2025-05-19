package vcmsa.ci.taariq_faker_st10479271_imad_assignement_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class FlashcardQuestionScreen : AppCompatActivity() {


    //Defining the array which will store the questions
    var questions = arrayOf(
        "Question 1: " +"The world cup was hosted in Qatar in 2022",
        "Question 2:" +"The US dollar in more valuable than the South African Rand",
        "Question 3: " + "Humans have 4 lungs ",
        "Question 4: " + "Humans can breathe under water",
        "Question 5: " + "There is more ants than there is humans"
    )


    //Deifning the array what will store the answers
    var answers= booleanArrayOf(
        true,
        true,
        false,
        false,
        true
    )

      val userAnswer= BooleanArray(questions.size) {false
      }

    //defining the score variable as well as setting it to 0 to ensure that it start at 0
    var score=0

    //defining the current index variable as well as setting it to 0 to ensure that it start at 0
    var currentIndex=0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_question_screen)


        //Defining the buttons and textview so that it is accessable in the program
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)



        showQuestion()


            //Codinng the true button so then when pressed it performs as intended
        trueButton.setOnClickListener {

            //When the button is clicked it cross referneces it the the check answer function
            checkAnswer(true)
        }

        falseButton.setOnClickListener {

            checkAnswer(false)
        }


             //Coding the what happens once the next button is clicked
        nextButton.setOnClickListener {

            currentIndex++

              //Using if statements to show the next question in the array until it reaches the end if the array

            if (currentIndex < questions.size) {
                //Shows the question
                showQuestion()
            } else {

                //Coding the button so that  once the questions is complete it will automatically go over to the score screen
                // connecting to the score screen as well as carrying over the information collected for the various variables
                val intent = Intent(this, ScoreScreen::class.java)

                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                intent.putExtra("Questions", questions)
                intent.putExtra("Answer", answers)
                intent.putExtra("userAnswer", userAnswer)

                startActivity(intent)
                finish()


            }
        }

    }






     private fun showQuestion (){
        val nextButton = findViewById<Button>(R.id.nextButton)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
         val questionText=findViewById<TextView>(R.id.questionText)

        questionText.text=questions[currentIndex]


      // Enabling the true and false button so that it appears in screen
        trueButton.isEnabled=true
        falseButton.isEnabled=true

        //Disabling the next button so that it does not show once the question is shown
        nextButton.isEnabled=false

    }

    private fun checkAnswer(studentAnswer:Boolean)
    {

        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        userAnswer[currentIndex]=studentAnswer



        if (studentAnswer==answers[currentIndex]) {
            Toast.makeText(this@FlashcardQuestionScreen, "The answer is correct", Toast.LENGTH_LONG).show()
            score++

        }
        else {
            Toast.makeText(this@FlashcardQuestionScreen, "The answer is incorrect", Toast.LENGTH_LONG).show()

        }

        trueButton.isEnabled=false
        falseButton.isEnabled=false
        nextButton.isEnabled=true



    }


}