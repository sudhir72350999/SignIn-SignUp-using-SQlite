package com.sudhirtheindian4.mysigninsignupsp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public  static  final String DbName = "Login.db";

    public DBHelper(@Nullable Context context) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table users(username TEXT primary key, password TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists users");

    }


    public  boolean insertData(String username, String password){
        SQLiteDatabase sqLiteDatabase =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password", String.valueOf(password));
        long result = sqLiteDatabase.insert("users",null,contentValues);
        if(result== -1){
            return false;    /// insertion is not possible

        }
        else{
            return true;
        }

    }

    public  boolean checkUserName(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?" ,new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public  boolean checkusername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0){
            return  true;
        }
        else {
            return false;
        }
    }
    public  boolean checkusernamepassword(String username , String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0){
            return  true;
        }
        else {
            return false;
        }
    }
}

