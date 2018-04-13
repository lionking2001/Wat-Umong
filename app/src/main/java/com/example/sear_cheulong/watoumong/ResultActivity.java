package com.google.android.gms.samples.vision.barcodereader.quiz;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.google.android.gms.samples.vision.barcodereader.R;


public class ResultActivity extends Activity {

    DonutProgress progress;
    int score, percentage;
    ImageView imgBack, imgReplay, imgRate;
    boolean time = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        progress = (DonutProgress)findViewById(R.id.donut_progress);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgReplay = (ImageView) findViewById(R.id.imgReplay);

        Bundle b = getIntent().getExtras();
        score = b.getInt("score");

        if(getIntent().hasExtra("time")){
            time = true;
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, QuizMenu.class);
                startActivity(intent);
                finish();
            }
        });

        imgReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                if(time){
                    intent.putExtra("time", true);
                }
                startActivity(intent);
                finish();
            }
        });




        percentage = (score*100)/20;

        if(percentage>=75){
            progress.setFinishedStrokeColor(getResources().getColor(R.color.green));
            progress.setTextColor(getResources().getColor(R.color.green));

        }else if(percentage>=50){
            progress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
            progress.setTextColor(getResources().getColor(R.color.yellow));
            getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));

        }else if(percentage>=25){
            progress.setFinishedStrokeColor(getResources().getColor(R.color.orange));
            progress.setTextColor(getResources().getColor(R.color.orange));
            getWindow().setStatusBarColor(getResources().getColor(R.color.orange));

        }else{
            progress.setFinishedStrokeColor(getResources().getColor(R.color.red));
            progress.setTextColor(getResources().getColor(R.color.red));
            getWindow().setStatusBarColor(getResources().getColor(R.color.red));

        }


        progress.setText(score + "/20");
        progress.setTextSize(96.0f);

        ObjectAnimator animation = ObjectAnimator.ofInt(progress, "progress", 0, percentage);
        animation.setDuration(50 * 25);//25 for a fast but not to fast animation
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }


}