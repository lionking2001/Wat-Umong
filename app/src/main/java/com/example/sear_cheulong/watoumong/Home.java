package com.example.sear_cheulong.watoumong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class Home extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Button general_info_btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        general_info_btn = (Button)findViewById(R.id.btn_info);
        general_info_btn.setOnClickListener(this);




    }


    @Override
    public void onClick(View view) {
        if(view==general_info_btn){
            intent = new Intent(Home.this,GeneralInfoList.class);
            startActivity(intent);
        }
    }
}
