package com.example.ddriverlogs;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * A simple k007 @link  database subclass.
 */

public class MyHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "KARAMDB";
    private static final String TABLE_USERS = "USERS";
    private static final String DRIVER_NAME = "driver_name";
    private static final String REGO = "rego";
    private static final String START_TIME = "start_time";
    private static final String FIRST_BREAK = "first_break";
    private static final String SECOND_BREAK = "second_break";
    private static final String END_TIME = "end_time";
    private static final String VEHICLE = "vehicle";
    private ArrayList<String> g = new ArrayList<>();


    MyHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_MyDB_TABLE = "CREATE TABLE USERS ( " +
                "driver_name TEXT, " +
                "rego TEXT, " +
                "start_time TEXT NOT NULL, " +
                "first_break TEXT NOT NULL, " +
                "second_break TEXT NOT NULL, " +
                "end_time TEXT NOT NULL, " +
                "vehicle TEXT NOT NULL )";
        db.execSQL(CREATE_MyDB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion < 3)
            db.execSQL("DROP TABLE IF EXISTS USERS");

        this.onCreate(db);
    }

    void addUser(String driver, String reg, String stime, String fbreak, String sbreak, String etime, String vcle) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DRIVER_NAME, driver);
        values.put(REGO, reg);
        values.put(START_TIME, stime);
        values.put(FIRST_BREAK, fbreak);
        values.put(SECOND_BREAK, sbreak);
        values.put(END_TIME, etime);
        values.put(VEHICLE, vcle);

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    ArrayList<String> getAllUsers(String vc_name) {
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE vehicle = '" + vc_name + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                String a = (cursor.getString(0));
                String b = (cursor.getString(1));
                String c = (cursor.getString(2));
                String d = (cursor.getString(3));
                String e = (cursor.getString(4));
                String f = (cursor.getString(5));

                g.add(a + b + c + d + e + f);
            } while (cursor.moveToNext());
        }


        return g;
    }

    void cleanDb(String name2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS ,VEHICLE + "=?", new String[]{name2});
        db.close();
    }
}