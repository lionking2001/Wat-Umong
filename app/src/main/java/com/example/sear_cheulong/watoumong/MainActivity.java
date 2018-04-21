package com.example.sear_cheulong.watoumong;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.blikoon.qrcodescanner.QrCodeActivity;
import com.example.sear_cheulong.watoumong.GeneralInformation.GeneralInfoList;
import com.example.sear_cheulong.watoumong.QrResult.ShowQrResult;
import com.example.sear_cheulong.watoumong.Quiz.QuizActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ImageButton general, quiz, btnScanner;

    private static final int REQUEST_CODE_QR_SCAN = 101;
    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        requirePermission();
}

    private void requirePermission() {
        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, Manifest.permission.CAMERA))
            permissionsNeeded.add("Camera");
        if (!addPermission(permissionsList, Manifest.permission.READ_EXTERNAL_STORAGE))
            permissionsNeeded.add("Read External Storage");
        if (!addPermission(permissionsList, Manifest.permission.VIBRATE))
            permissionsNeeded.add("Vibrate");

        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                String message = "You need to grant access to " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            }
            requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        }
    }

    @SuppressLint("WrongViewCast")
    private void init() {

        general = (ImageButton) findViewById(R.id.general_information);
        quiz = (ImageButton) findViewById(R.id.Quiz);

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GeneralInfoList.class);
                startActivity(intent);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(intent);

            }
        });

        btnScanner =  findViewById(R.id.btnScanner);
        btnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requirePermission();

                Intent i = new Intent(MainActivity.this, QrCodeActivity.class);
                startActivityForResult(i, REQUEST_CODE_QR_SCAN);
            }
        });

    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != Activity.RESULT_OK) {
//            Log.d(DEBUG,"COULD NOT GET A GOOD RESULT.");
            if (data == null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("com.blikoon.qrcodescanner.error_decoding_image");
            if (result != null) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Scan Error");
                alertDialog.setMessage("QR Code could not be scanned");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
            return;

        }
        if (requestCode == REQUEST_CODE_QR_SCAN) {
            if (data == null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("com.blikoon.qrcodescanner.got_qr_scan_relult");
//            Log.d(LOGTAG,"Have scan result in your app activity :"+ result);
//            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//            alertDialog.setTitle("Scan result");
//            alertDialog.setMessage(result);
//            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//            alertDialog.show();

            Intent intent = null;

            switch(result) {
                case "1":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 0);
                    startActivity(intent);
                    break;
                case "2":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 1);
                    startActivity(intent);
                    break;
                case "3":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 2);
                    startActivity(intent);
                    break;
                case "4":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 3);
                    startActivity(intent);
                    break;
                case "5":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 4);
                    startActivity(intent);
                    break;
                case "6":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 5);
                    startActivity(intent);
                    break;
                case "7":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 6);
                    startActivity(intent);
                    break;
                case "8":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 7);
                    startActivity(intent);
                    break;
                case "9":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 8);
                    startActivity(intent);
                    break;
                case "10":
                    intent = new Intent(MainActivity.this, ShowQrResult.class);
                    intent.putExtra("index", 9);
                    startActivity(intent);
                    break;
                default:
            }

        }
    }

}
