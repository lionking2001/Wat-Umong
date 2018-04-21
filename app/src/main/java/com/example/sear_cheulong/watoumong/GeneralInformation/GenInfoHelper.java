package com.example.sear_cheulong.watoumong.GeneralInformation;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sear_cheulong.watoumong.R;

public class GenInfoHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "wat_umong";
    // tasks table name
    private static final String TABLE_NAME = "general_information";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_IMG = "img";
    private static final String KEY_DESC = "description";

    private SQLiteDatabase dbase;

    public GenInfoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TITLE
                + " TEXT, " + KEY_DESC + " TEXT, "+ KEY_IMG + " INT)";
        db.execSQL(sql);
        addInformation();
        // db.close();
    }

    private void addInformation() {

        GeneralInformation gi1 = new GeneralInformation("Test","Test Description",R.drawable.qr_01);
        this.addInformation(gi1);

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
    public void addInformation(GeneralInformation gi) {
//         SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, gi.getTitle());
        values.put(KEY_IMG, gi.getImg());
        values.put(KEY_DESC, gi.getDescription());
        // Inserting Row
        dbase.insert(TABLE_NAME, null, values);
    }

    public List<GeneralInformation> getAllGeneralInformation() {
        List<GeneralInformation> giList = new ArrayList<GeneralInformation>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                GeneralInformation gi = new GeneralInformation();
                gi.setTitle(cursor.getString(1));
                gi.setDescription(cursor.getString(2));
                gi.setImg(cursor.getInt(3));

                giList.add(gi);
            } while (cursor.moveToNext());
        }
        // return quest list
        return giList;
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