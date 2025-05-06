package vcmsa.ci.taariq_faker_st10479271_imad_assignement_2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashcardQuestionScreen : AppCompatActivity() {

    var questions = arrayOf<String>(
        "Question 1 /n" +"The world cup was hosted in Qatar in 2022",
        "Question 2 /n" +"The US dollar in more valuable than the South African Rand",
        "Question 3 /n" + "Humans have 4 lungs ",
        "Question 4 /n" + "Humans can breathe under water",
        "Question 5 /n" + "There is more ants than there is humans"
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

        showQuestion(currentIndex)

        trueButton.setOnClickListener {

            checkAnswer(true)
        }

        falseButton.setOnClickListener {

            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex++
        }
        if (currentIndex < totalQuestions) {
            showQuestion(currentIndex)
            trueButton.isEnabled = true
            falseButton.isEnabled = true
        } else {
            FinalScore()
        }

        for (question in questions) {
            questionText.setText("Flashcard:+ $question")
        }

        fun showQuestion (index:Int){
            questionText.text="Question ${index +1}:${questions[index]}"

        }
        fun checkAnswer(studentAnswer:Boolean)
        {
            if (studentAnswer==answers[currentIndex]) {
                Toast.makeText(this@FlashcardQuestionScreen, "The answer is correct", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(
                    this@FlashcardQuestionScreen,
                    "The answer is incorrect",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        fun FinalScore()
        {
            questionText.text="Quiz Complete"
            scoreTextView.text="You score: $score out of $totalQuestions"
            trueButton.isEnabled=false
            falseButton.isEnabled=false
            nextButton.isEnabled=false
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}