package com.example.sear_cheulong.watoumong.QrResult;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sear_cheulong.watoumong.R;

public class QrResultHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "wat_umong_qr";
    // tasks table name
    private static final String TABLE_NAME = "qr_result";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_KEY = "keyword";
    private static final String KEY_TITLE = "title";
    private static final String KEY_IMG = "img";
    private static final String KEY_DESC = "description";

    private SQLiteDatabase dbase;

    public QrResultHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_KEY + " TEXT, "
                + KEY_TITLE + " TEXT, "
                + KEY_DESC + " TEXT, "
                + KEY_IMG + " INT "
                + ")";
        db.execSQL(sql);

        addInformation();
//        db.close();
    }

    private void addInformation() {

        QrResult qr1 = new QrResult("1",
                "All tunnel with number tag",
                "There are 6 tunnels, but the only found parts of mural paintings in tunnel number 1, 2 and 3.",
                R.drawable.qr_01);
        this.addInformation(qr1);

        QrResult qr2 = new QrResult("2",
                "Sample pattern of painting in tunnel number three",
                "Lotuses and Specific Patterns in tunnel number three using computer graphic",
                R.drawable.qr_02);
        this.addInformation(qr2);

        QrResult qr3 = new QrResult("3",
                "Sample Pattern of painting in tunnel number two",
                "Lotuses and Cloud patterns in tunnel number three using computer graphic",
                R.drawable.qr_03);
        this.addInformation(qr3);

        QrResult qr4 = new QrResult("4",
                "Sample Pattern of painting in tunnel number one",
                "Birds and Peonies patterns in tunnel number three using computer graphic",
                R.drawable.qr_04);
        this.addInformation(qr4);

        QrResult qr5 = new QrResult("5",
                "Male Peacock on painting in tunnel number one",
                "",
                R.drawable.qr_05);
        this.addInformation(qr5);

        QrResult qr6 = new QrResult("6",
                "Parrot on painting in tunnel number one",
                "",
                R.drawable.qr_06);
        this.addInformation(qr6);

        QrResult qr7 = new QrResult("7",
                "Herons on painting in tunnel number one",
                "",
                R.drawable.qr_07);
        this.addInformation(qr7);

        QrResult qr8 = new QrResult("8",
                "Chinese Phoenix on painting in tunnel number one",
                "",
                R.drawable.qr_08);
        this.addInformation(qr8);

        QrResult qr9 = new QrResult("9",
                "Red color of painting : Cinnabar",
                "",
                R.drawable.qr_09);
        this.addInformation(qr9);

        QrResult qr10 = new QrResult("10",
                "Green color of painting : Malachite",
                "",
                R.drawable.qr_10);
        this.addInformation(qr10);



        // END
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addInformation(QrResult qr) {
//         SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KEY, qr.getKeyword());
        values.put(KEY_TITLE, qr.getTitle());
        values.put(KEY_IMG, qr.getImg());
        values.put(KEY_DESC, qr.getDescription());
        // Inserting Row
        dbase.insert(TABLE_NAME, null, values);
    }

    public List<QrResult> getAllResult() {
        List<QrResult> qrList = new ArrayList<QrResult>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QrResult qr = new QrResult();
                qr.setKeyword(cursor.getString(1));
                qr.setTitle(cursor.getString(2));
                qr.setDescription(cursor.getString(3));
                qr.setImg(cursor.getInt(4));

                qrList.add(qr);
            } while (cursor.moveToNext());
        }
        // return quest list
        return qrList;
    }

    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

}