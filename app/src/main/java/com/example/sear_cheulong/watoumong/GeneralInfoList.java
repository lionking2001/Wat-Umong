package com.example.sear_cheulong.watoumong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lenovo user on 6/4/2561.
 */

public class GeneralInfoList extends AppCompatActivity implements View.OnClickListener {
    Button info_1;
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generalinfolist);

        info_1 = (Button)findViewById(R.id.info_1);
        info_1.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        if(view == info_1){
            intent = new Intent(GeneralInfoList.this,Info1.class);
            startActivity(intent);
        }

    }
}
