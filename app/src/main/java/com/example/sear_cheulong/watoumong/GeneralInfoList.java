package com.example.sear_cheulong.watoumong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
=======
>>>>>>> 7519faa590f3217287747fddd4187945174ad799
import android.view.View;
import android.widget.Button;

public class GeneralInfoList extends AppCompatActivity implements View.OnClickListener {
    CardView info_1,info_2,info_3,info_4;
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generalinfolist);


        info_1 = (CardView) findViewById(R.id.info1);
        info_1.setOnClickListener(this);
        info_2 = (CardView)findViewById(R.id.info2);
        info_2.setOnClickListener(this);
        info_3 = (CardView)findViewById(R.id.info3);
        info_3.setOnClickListener(this);
        info_4 = (CardView)findViewById(R.id.info4);
        info_4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == info_1) {
            intent = new Intent(GeneralInfoList.this, Info1.class);
            startActivity(intent);
        }
        if(view == info_2){
            intent = new Intent(GeneralInfoList.this,Info2.class);
            startActivity(intent);
        }
        if(view == info_3){
            intent = new Intent(GeneralInfoList.this,Info3.class);
            startActivity(intent);
        }
        if(view == info_4){
            intent = new Intent(GeneralInfoList.this,Info4.class);
            startActivity(intent);
        }

    }
}
