package com.example.rawda.prettychat.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rawda.prettychat.R;
import com.example.rawda.prettychat.data.local.DatabaseManager;
import com.example.rawda.prettychat.data.local.MyDatabaseHelper;
import com.example.rawda.prettychat.data.local.UserDBManager;
import com.example.rawda.prettychat.data.models.User;

import java.util.List;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText username_editText;
    private EditText email_editText;
    private EditText password_editText;
    private Button sign_up_button;
    private String username, email, password;
    private DatabaseManager databaseManager;
    private MyDatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        databaseHelper = new MyDatabaseHelper(this);
        databaseManager.initializeInstance(databaseHelper);
        username_editText = findViewById(R.id.username_edit_text);
        email_editText = findViewById(R.id.email_edit_text);
        password_editText = findViewById(R.id.password_edit_text);
        sign_up_button = findViewById(R.id.sign_up_button);
        sign_up_button.setOnClickListener(this);
        username = username_editText.getText().toString();
        email = email_editText.getText().toString();
        password = password_editText.getText().toString();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.sign_up_button){
            User user = new User();
            user.setUserName(username);
            user.setEmail(email);
            user.setPassword(password);
            boolean isValid = checkValidUser(user);
            if (isValid){
                signUp(user);
                succeeded();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }else{
                failed();
            }
        }
    }

    private void signUp(User user) {
        UserDBManager.addUser(user);
    }

    private boolean checkValidUser(User user) {
        List<User> usersMatchingEmail = UserDBManager.getUsersMatchingEmail(email);
        List<User> usersMatchingUsername = UserDBManager.getUsersMatchingUsername(username);
        if (usersMatchingEmail.size() > 0 || usersMatchingUsername.size() > 0){
            return false;
        }
        return true;
    }
    private void succeeded(){
        Toast.makeText(this, "succeeded", Toast.LENGTH_LONG).show();
    }
    private void failed(){
        Toast.makeText(this, "failed", Toast.LENGTH_LONG).show();
    }
}
