package com.example.sear_cheulong.watoumong.QrResult;

import android.content.Context;

import java.util.List;

/**
 * Created by nayza on 21/4/2561.
 */

public class QrResults {

    private static QrResults instance;
    private List<QrResult> qrResultList;

    public static QrResults getInstance(Context context) {

        if (instance == null){
            instance = new QrResults(context);
        }

        return instance;
    }

    public QrResults (Context context){
        QrResultHelper db = new QrResultHelper(context);
        qrResultList = db.getAllResult();
    }

    public List<QrResult> getQrResultList(){
        return qrResultList;
    }
}
