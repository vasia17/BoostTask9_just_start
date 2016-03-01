package com.example.shon.boosttask8_navigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vasia on 01.03.2016.
 * I know, I`ll do it.)
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myDB.db";
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "uid";
    public static final String COL_2 = "displayName";
    public static final String COL_3 = "email";
    public static final String COL_4 = "profileImageUrl";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY, " + COL_2 + " TEXT, " + COL_3 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String uid , String displayName, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, uid);
        contentValues.put(COL_2, displayName);
        contentValues.put(COL_3, email);
        db.insert(TABLE_NAME, null, contentValues);

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME, null);
        return result;
    }
}
