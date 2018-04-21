package com.example.sear_cheulong.watoumong;

/**
 * Created by nira on 11/16/2017.
 */

public class QrResult {

    int resId[] = {
            R.drawable.qr_01,
            R.drawable.qr_02,
            R.drawable.qr_03,
            R.drawable.qr_04,
            R.drawable.qr_05,
            R.drawable.qr_06,
            R.drawable.qr_07,
            R.drawable.qr_08,
            R.drawable.qr_09,
            R.drawable.qr_10
    };

    String topic[] = {
            // 1
            "All tunnel with number tag",
            // 2
            "Sample pattern of painting in tunnel number three",
            // 3
            "Sample Pattern of painting in tunnel number two",
            // 4
            "Sample Pattern of painting in tunnel number one",
            // 5
            "Male Peacock on painting in tunnel number one",
            // 6
            "Parrot on painting in tunnel number one",
            // 7
            "Herons on painting in tunnel number one",
            // 8
            "Chinese Phoenix on painting in tunnel number one",
            // 9
            "Red color of painting : Cinnabar",
            // 10
            "Green color of painting : Malachite",
            // 11
            ""
    };

    String detail[] ={
            // 1
            "There are 6 tunnels, but the only found parts of mural paintings in tunnel number 1, 2 and 3.",
            // 2
            "Lotuses and Specific Patterns in tunnel number three using computer graphic",
            // 3
            "Lotuses and Cloud patterns in tunnel number three using computer graphic",
            // 4
            "Birds and Peonies patterns in tunnel number three using computer graphic",
            // 5
            "",
            // 6
            "",
            // 7
            "",
            // 8
            "",
            // 9
            "",
            // 10
            "",
            // 11
            ""
    };



    public int getResId(int i) {
        return resId[i];
    }

    public String getDetail(int i) {
        return detail[i];
    }

    public String getTopic(int i) {
        return topic[i];
    }
}
