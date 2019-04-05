package com.example.rawda.prettychat.data.local;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rawda.prettychat.data.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDBManager {
    private static String TAG = UserDBManager.class.getSimpleName();
    private static DatabaseManager databaseManager;
    public static final String TABLE_Name = "user";
    public static String[] columns = {"_id", "fname", "lname", "email", "username",
            "password", "birth_date", "phone_num", "address", "photo"};



    //TODO change Photo Col Type
    public static String CREATE_USER_QUERY = "create table " + TABLE_Name + " (" + columns[0] + " integer auto increment, " + columns[1]
            + " text, " + columns[2] + " text, " + columns[3] + " text, " + columns[4] + " text, "
            + columns[5] + " text, " + columns[6] + " date, " + columns[7] + " text, " + columns[8]
            + " text, " + columns[9] + " blob);";

    public static String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_Name;

    public static boolean addUser(User user){
         SQLiteDatabase sqLiteDatabase = databaseManager.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(columns[0], user.getfName());
        contentValues.put(columns[1], user.getlName());
        contentValues.put(columns[2], user.getEmail());
        contentValues.put(columns[3], user.getUserName());
        contentValues.put(columns[4], user.getPassword());
        //TODO convert to sql data
        contentValues.put(columns[5], "");
        contentValues.put(columns[6], user.getPhone_number());
        contentValues.put(columns[1], user.getAddress());
        contentValues.put(columns[2], user.getPhoto());
       long numberOfRows = sqLiteDatabase.insert(TABLE_Name, null, contentValues);
       databaseManager.getInstance().closeDatabase();
       return numberOfRows > 0;
    }
    public static List<User> getAllUsers() {
        SQLiteDatabase sqLiteDatabase = databaseManager.getInstance().openDatabase();
        List<User> users = new ArrayList<>();
        User user = null;
        String query = "select * from " + TABLE_Name + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToNext()) {
            do {
                user = new User(cursor.getLong(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), new Date(), cursor.getString(7),
                        cursor.getString(8), cursor.getBlob(9));

                users.add(user);
            } while (cursor.moveToNext());

        }
        return users;
    }

    public static List<User> getUsersMatchingEmail(String email) {
        SQLiteDatabase sqLiteDatabase = databaseManager.getInstance().openDatabase();
        List<User> users = new ArrayList<>();
        User user = null;
        String query = "select * from " + TABLE_Name + " where email = '" + email + "';";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToNext()) {
            do {
                user = new User(cursor.getLong(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), new Date(), cursor.getString(7),
                        cursor.getString(8), cursor.getBlob(9));

                users.add(user);
            } while (cursor.moveToNext());

        }
        return users;
    }
    public static List<User> getUsersMatchingUsername(String username) {
        SQLiteDatabase sqLiteDatabase = databaseManager.getInstance().openDatabase();
        List<User> users = new ArrayList<>();
        User user = null;
        String query = "select * from " + TABLE_Name + " where username = '" + username + "';";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToNext()) {
            do {
                user = new User(cursor.getLong(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), new Date(), cursor.getString(7),
                        cursor.getString(8), cursor.getBlob(9));

                users.add(user);
            } while (cursor.moveToNext());

        }
        return users;
    }/*
    private static Date convertFromStringToDate(String date){

        String day = "", month = "", year = "";
        for (int i = 0; i < date.length(); i++){
            if (i == '/' && i < 2) day = date.substring(0, i);
            if (i == '/' && i < 5) month = date.substring(i + 1, 5);
            if (i == '/' && i < date.length()) year = date.substring(i  + 1, date.length());
        }
        return new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt((year)));
    }*/
}
