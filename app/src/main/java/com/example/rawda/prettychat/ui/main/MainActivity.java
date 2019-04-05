package com.example.rawda.prettychat.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rawda.prettychat.R;
import com.example.rawda.prettychat.data.local.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabaseHelper sqLiteOpenHelper = new MyDatabaseHelper(this);
        Log.d("Database Name", sqLiteOpenHelper.toString());

    }
}
