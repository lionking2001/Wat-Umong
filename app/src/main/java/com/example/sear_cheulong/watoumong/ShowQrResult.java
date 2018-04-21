package com.example.sear_cheulong.watoumong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lenovo user on 6/4/2561.
 */

public class ShowQrResult extends AppCompatActivity {

    QrResult result;
    TextView topic,detail;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrresult);

        result = new QrResult();

        int index = getIntent().getIntExtra("index",0);

        topic = (TextView) findViewById(R.id.tvQrTopic);
        topic.setText(result.getTopic(index));

        detail = (TextView) findViewById(R.id.tvQrDescription);
        detail.setText(result.getDetail(index));

        pic = (ImageView) findViewById(R.id.imgQr);
        pic.setImageResource(result.getResId(index));
    }
}
