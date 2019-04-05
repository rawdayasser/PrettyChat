package com.example.rawda.prettychat.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "pretty_chat";
    public static int VERSION = 1;
    public static final String TABLE_USER = "user";
    public static final String TABLE_PREMIUM = "premium_user";
    public static final String[] TABLES = new String[]{"user", "premium_user", "post", "like", "comment", "reply",
            "message", "advertisement", "page"
    };
    private UserDBManager userDBManager;
    private static Context context;

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

        sqLiteDatabase.execSQL(UserDBManager.CREATE_USER_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLES[0]);
        onCreate(sqLiteDatabase);

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
        StringBuilder
                message = new StringBuilder();
        message.append("Database name ").append(getDatabaseName())
                .append("VERSION ").append(VERSION);

        return message.toString();
    }
}
