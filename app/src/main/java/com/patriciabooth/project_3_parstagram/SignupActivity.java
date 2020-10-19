package com.patriciabooth.project_3_parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

// https://guides.codepath.org/android/Building-Data-driven-Apps-with-Parse#user-signup

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    public final int REQUEST_OK = 73;

    private EditText etNewUsername;
    private EditText etNewPassword;
    private Button btnSubmitSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etNewUsername = findViewById(R.id.etNewUsername);
        etNewPassword = findViewById(R.id.etNewPassword);
        btnSubmitSignup = findViewById(R.id.btnSubmitSignup);

        btnSubmitSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Clicked signup submit button on signup page");
                String username = etNewUsername.getText().toString();
                String password = etNewPassword.getText().toString();
                createAccount(username,password);
            }
        });
    }

    private void createAccount(String username, String password) {
        Log.i(TAG, "Attempting to create account " + username);
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set properties
        user.setUsername(username);
        user.setPassword(password);
        // Call signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                // Successful signup
                if (e == null) {
                    Log.i(TAG, "Successfully created account.");
                    Toast.makeText(SignupActivity.this,
                            "Successfully created account. You may now sign in.", Toast.LENGTH_SHORT).show();
                    // Return to Login Activity
                    setResult(REQUEST_OK);
                    finish();
                }
                // Unsuccessful signup
                else {
                    Log.e(TAG, "Issue with signing up", e);
                    Toast.makeText(SignupActivity.this,
                            "Problem with creating account", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }
}