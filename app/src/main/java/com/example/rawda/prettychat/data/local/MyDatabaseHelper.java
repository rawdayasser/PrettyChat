package com.example.rawda.prettychat.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "pretty_chat";
    private static int VERSION = 1;
    private Context context;
    private static String create_table_User = "create table user (_id number primary key, fname text," +
            "lname text,  email text, username text, password text, birth_date text, phone_number text," +
            "address text);";
    private static String create_table_Premium = "create table user (_id number primary key, fname text," +
            "lname text,  email text, username text, password text, birth_date text, phone_number text," +
            "address text, credit_card_number double);";

    private static String create_table_Post;
    private static String create_table_Comment;
    private static String create_table_Reply;
    private static String create_table_Message;
    private static String create_table_Like;

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                            int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_table_User);
        String insert = "insert into user(fname, lname, email, username) values('Rawda', 'Yasser', 'abc@gmail.com', 'rawda')";
        String insert1 = "insert into user(fname, lname, email, username) values('Diaa', 'Yasser', 'diaa@gmail.com', 'rawda')";
        sqLiteDatabase.execSQL(insert);
        sqLiteDatabase.execSQL(insert1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");
        onCreate(sqLiteDatabase);

    }
    public void displayData(){
        Cursor cursor = getWritableDatabase().rawQuery("select * from user", null);
        if (cursor.moveToNext()){
            do{
                Log.d("Table User", cursor.getString(0) + " " + cursor.getString(1) + cursor.getString(2));
            }while (cursor.moveToNext());

        }
    }
    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      super.onDowngrade(db, oldVersion, newVersion);

    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("Database name ").append(getDatabaseName())
                .append("VERSION ").append(VERSION);

        return message.toString();
    }
}
