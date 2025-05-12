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

    var questions = arrayOf<String>(
        "Question 1: " +"The world cup was hosted in Qatar in 2022",
        "Question 2:" +"The US dollar in more valuable than the South African Rand",
        "Question 3: " + "Humans have 4 lungs ",
        "Question 4: " + "Humans can breathe under water",
        "Question 5: " + "There is more ants than there is humans"
    )

    var answers= arrayOf(
        true,
        true,
        false,
        false,
        true
    )

    var score=0

    var currentIndex=0

    var totalQuestions=questions.size



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_question_screen)

        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val questionText = findViewById<TextView>(R.id.questionText)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val scoreTextView=findViewById<TextView>(R.id.scoreText)
        val finalScore=findViewById<Button>(R.id.finalScoreButton)

        showQuestion(currentIndex, questionText)

        trueButton.setOnClickListener {

            checkAnswer(true)
        }

        falseButton.setOnClickListener {

            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex++


            if (currentIndex < totalQuestions) {
                showQuestion(currentIndex, questionText)
            } else {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", totalQuestions)
                startActivity(intent)
                finish()


            }
        }



    }

    fun showQuestion (index:Int, tv:TextView){
        val nextButton = findViewById<Button>(R.id.nextButton)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)

        tv.text=questions[index]



        trueButton.isEnabled=true
        falseButton.isEnabled=true
        nextButton.isEnabled=false

    }

    fun checkAnswer(studentAnswer:Boolean)
    {
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

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