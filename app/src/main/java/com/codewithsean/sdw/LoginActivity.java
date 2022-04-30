package com.codewithsean.sdw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codewithsean.sdw.MainActivity;
//import com.parse.LogInCallback;
//import com.parse.ParseUser;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        if(ParseUser.getCurrentUser() != null) {
//            goMainActivity();
//        }
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onCLick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                //loginUser(username, password);


                //testing line
                goMainActivity();

            }
        });

    }

//    private void loginUser(String username, String password) {
//        Log.i(TAG, "Attempting to login user " + username);
//        ParseUser.logInInBackground(username, password, new LogInCallback() {
//            @Override
//            public void done(ParseUser user, com.parse.ParseException e) {
//                if (e != null) {
//                    Log.e(TAG, "Issues with log in", e);
//                    Toast.makeText(LoginActivity.this, "Issue with login", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                //navigate to the main activity if the user sign in properly
//                goMainActivity();
//                Toast.makeText(LoginActivity.this, "Success:", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}