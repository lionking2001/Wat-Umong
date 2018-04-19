package com.example.sear_cheulong.watoumong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.sear_cheulong.watoumong.GeneralInformation.GeneralInfoList;
import com.example.sear_cheulong.watoumong.GeneralInformation.Info1;
import com.example.sear_cheulong.watoumong.Quiz.QuizActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton general,quiz;
        general = (ImageButton) findViewById(R.id.general_information);
        quiz = (ImageButton) findViewById(R.id.Quiz);

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(MainActivity.this,GeneralInfoList.class);
                startActivity(intent);
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(intent);

            }
        });
}

}
