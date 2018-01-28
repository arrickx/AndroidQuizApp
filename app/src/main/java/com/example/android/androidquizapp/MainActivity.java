package com.example.android.androidquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * This app create a quiz app that can submit answer and shows the score.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * It creates global variable for the views.
     */
    LinearLayout questionsPage;
    LinearLayout resultPage;
    RadioButton q1Answer;
    RadioButton q2Answer;
    RadioButton q3Answer;
    RadioButton q6Answer;
    CheckBox q4Answer1;
    CheckBox q4Answer2;
    CheckBox q4Answer3;
    CheckBox q5Answer1;
    CheckBox q5Answer2;
    TextView finalScoreMessage;
    String finalMessage;
    EditText nameInput;
    String userName;
    /**
     * It initialize the final score and provide the total number of questions.
     */
    int finalScore = 0;
    int totalQuestion = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * This initialize all the views that was created above.
         */
        questionsPage = findViewById(R.id.questions_page);
        resultPage = findViewById(R.id.result_page);
        q1Answer = findViewById(R.id.q1_answer);
        q2Answer = findViewById(R.id.q2_answer);
        q3Answer = findViewById(R.id.q3_answer);
        q6Answer = findViewById(R.id.q6_answer);
        q4Answer1 = findViewById(R.id.q4b);
        q4Answer2 = findViewById(R.id.q4c);
        q4Answer3 = findViewById(R.id.q4d);
        q5Answer1 = findViewById(R.id.q5b);
        q5Answer2 = findViewById(R.id.q5d);
        finalScoreMessage = findViewById(R.id.finalScoreMessage);
        nameInput = findViewById(R.id.inputName);
    }

    /**
     * This function verify the answer from input and generates the scores.
     */
    public void answerVerification() {
        boolean q1Correct = q1Answer.isChecked();
        boolean q2Correct = q2Answer.isChecked();
        boolean q3Correct = q3Answer.isChecked();
        boolean q6Correct = q6Answer.isChecked();
        boolean q4Correct1 = q4Answer1.isChecked();
        boolean q4Correct2 = q4Answer2.isChecked();
        boolean q4Correct3 = q4Answer3.isChecked();
        boolean q5Correct1 = q5Answer1.isChecked();
        boolean q5Correct2 = q5Answer2.isChecked();
        userName = nameInput.getText().toString();

        if (q1Correct) {
            finalScore += 1;
        }
        if (q2Correct) {
            finalScore += 1;
        }
        if (q3Correct) {
            finalScore += 1;
        }
        if (q6Correct) {
            finalScore += 1;
        }
        if (q4Correct1 && q4Correct2 && q4Correct3) {
            finalScore += 1;
        }
        if (q5Correct1 && q5Correct2) {
            finalScore += 1;
        }
        if (userName.isEmpty()) {
            userName = getString(R.string.noName);
        }

        float scoreInHundred = (float) (finalScore) / totalQuestion * 100;
        String scoreTwoDigit = String.format("%.02f", scoreInHundred);

        finalMessage = "Hello " + userName + "!"
                + "\n \nYou got " + finalScore + " of " + totalQuestion + " questions correct!"
                + "\n \nThe total score is " + scoreTwoDigit;
    }

    /**
     * This submit the answer when the submit button has been clicked.
     */
    public void submitAnswer(View view) {
        answerVerification();
        questionsPage.setVisibility(View.GONE);
        resultPage.setVisibility(View.VISIBLE);
        finalScoreMessage.setText(finalMessage);
    }

    /**
     * This function reset the app when you click reset button.
     */
    public void resetQuestion(View view) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}
