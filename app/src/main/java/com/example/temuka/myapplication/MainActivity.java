package com.example.temuka.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button Answer1, Answer2, Answer3, Answer4;
    TextView score, question;
    private Questions mQuestions = new Questions();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestion.length;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();

        Answer1 = (Button) findViewById(R.id.Answer1);
        Answer2 = (Button) findViewById(R.id.Answer2);
        Answer3 = (Button) findViewById(R.id.Answer3);
        Answer4 = (Button) findViewById(R.id.Answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        score.setText(mScore + "/30");

        updateQuestion(r.nextInt(mQuestionsLength));


        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Answer1.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }

            }
        });
        Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Answer2.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }

            }
        });
        Answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Answer3.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }

            }
        });
        Answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Answer4.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }

            }
        });

    }

    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));
        Answer1.setText(mQuestions.getChoice1(num));
        Answer2.setText(mQuestions.getChoice2(num));
        Answer3.setText(mQuestions.getChoice3(num));
        Answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over!" + mScore + "points")
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            }
                        })
                .setNegativeButton("Wrong",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}





