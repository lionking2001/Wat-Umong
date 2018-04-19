package com.example.sear_cheulong.watoumong.Quiz;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sear_cheulong.watoumong.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity {
    List<Question> quesList;
    CounterClass timer;
    int score = 0;
    int quiz = 0;
    int qid = 0;
    int qNum = 0;
    int rowCount;
    Boolean isCorrect = false;
    TextView txtQuestion, txtScore, txtTime,textQuestion1,textQuestion2,textQuestion3,textQuestion4;

    ImageButton btnOptA, btnOptB, btnOptC, btnOptD;
    Boolean time = false;
    ImageView imgBack;
    ArrayList<Integer> numbers;


    Question currentQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        QuizHelper db = new QuizHelper(this);
        quesList = db.getAllQuestions();
        rowCount = db.getProfilesCount();
//        URN();
//        qid = numbers.get(qNum);
//        numbers.get(qNum);
        qid = qNum;


        currentQ = quesList.get(qid);


        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        btnOptA = (ImageButton) findViewById(R.id.btnOne);
        btnOptB = (ImageButton) findViewById(R.id.btnTwo);
        btnOptC = (ImageButton) findViewById(R.id.btnThree);
        btnOptD = (ImageButton) findViewById(R.id.btnFour);
        txtScore = (TextView) findViewById(R.id.txtScore);
        textQuestion1 = (TextView) findViewById(R.id.textQuestion1);
        textQuestion2 = (TextView) findViewById(R.id.textQuestion2);
        textQuestion3=(TextView) findViewById(R.id.textQuestion3);
        textQuestion4 = (TextView) findViewById(R.id.textQuestion4);


        if (getIntent().hasExtra("time")) {
            time = true;
            txtTime.setText("00:01:00");

            timer = new CounterClass(60000, 1000);
            timer.start();
        }


        setQuestionView();


        btnOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(textQuestion1.getText().toString(), 1);
            }
        });

        btnOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(textQuestion2.getText().toString(), 2);
            }
        });

        btnOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(textQuestion3.getText().toString(), 3);

            }
        });

        btnOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(textQuestion4.getText().toString(), 4);

            }
        });

//        imgBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(QuizActivity.this, QuizMenu.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void getAnswer(String AnswerString, int i) {
        if (currentQ.getANSWER().equals(AnswerString)) {

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score++;
            txtScore.setText(String.valueOf(score));

            switch (i) {
                case 1:
                    btnOptA.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 2:
                    btnOptB.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 3:
                    btnOptC.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 4:
                    btnOptD.setBackgroundColor(getResources().getColor(R.color.green));
                    break;


            }


        } else {
            switch (i) {
                case 1:
                    btnOptA.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 2:
                    btnOptB.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 3:
                    btnOptC.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 4:
                    btnOptD.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
            }


        }
        if (quiz < 19) {

            // if questions are not over then do this
            currentQ = quesList.get(qid);


            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setQuestionView();
                    reset();
                }
            }, 100);
        } else {

            // if over do this
            Intent intent = new Intent(QuizActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            if (time) {
                b.putBoolean("time", true);
            }
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

        quiz++;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            txtTime.setText("Time is up");
            Intent intent = new Intent(QuizActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            b.putBoolean("time", true);
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            @SuppressLint("DefaultLocale") String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            txtTime.setText(hms);
        }

    }

    private void setQuestionView() {

        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        textQuestion1.setText(currentQ.getOPTA());
        textQuestion2.setText(currentQ.getOPTB());
        textQuestion3.setText(currentQ.getOPTC());
        textQuestion4.setText(currentQ.getOPTD());

        qNum++;

//        qid = numbers.get(qNum);
//        numbers.get(qNum);
        qid = qNum;


    }

    public void reset() {
        btnOptA.setBackgroundColor(getResources().getColor(R.color.gray));
        btnOptB.setBackgroundColor(getResources().getColor(R.color.gray));
        btnOptC.setBackgroundColor(getResources().getColor(R.color.gray));
        btnOptD.setBackgroundColor(getResources().getColor(R.color.gray));

    }

//    public void URN() {
//
//
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        numbers = new ArrayList<Integer>();
//        for (int i = 0; i < rowCount; i++) {
//            list.add(new Integer(i));
//        }
//        Collections.shuffle(list);
//        for (int i = 0; i < 11; i++) {
//            numbers.add(new Integer(list.get(i)));
//        }
//
//    }


}