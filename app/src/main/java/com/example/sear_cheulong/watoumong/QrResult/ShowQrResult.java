package com.example.sear_cheulong.watoumong.QrResult;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sear_cheulong.watoumong.R;

/**
 * Created by Lenovo user on 6/4/2561.
 */

public class ShowQrResult extends AppCompatActivity {

    QrResult qrResult;
    TextView title,detail;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrresult);

        int index = getIntent().getIntExtra("index",0);

        qrResult = QrResults.getInstance(this).getQrResultList().get(index);


        title = (TextView) findViewById(R.id.tvQrTopic);
        title.setText(qrResult.getTitle());

        detail = (TextView) findViewById(R.id.tvQrDescription);
        detail.setText(qrResult.getDescription());

        pic = (ImageView) findViewById(R.id.imgQr);
        pic.setImageResource(qrResult.getImg());
    }
}
