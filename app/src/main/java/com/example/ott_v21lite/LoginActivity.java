package com.example.ott_v21lite;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonSignUp;
    private UserDatabaseHelper userDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize database helper
        userDatabaseHelper = new UserDatabaseHelper(this);

        // Initialize UI components
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        // Set click listener for login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve username and password entered by the user
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Check if the username and password are not empty
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Query the database to check if the user exists and if the password matches
                    boolean isAuthenticated = checkCredentials(username, password);
                    if (isAuthenticated) {
                        // If authentication is successful, proceed to the main activity or perform necessary actions
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        // You can start the main activity here or perform any other actions
                    } else {
                        // If authentication fails, display an error message
                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // If username or password is empty, display an error message
                    Toast.makeText(LoginActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for sign-up button
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SignUpActivity when sign-up button is clicked
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        // Set up video background
        VideoView videoViewBackground = findViewById(R.id.videoViewBackground);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.loginbackgroud);
        videoViewBackground.setVideoURI(videoUri);
        videoViewBackground.start();
        videoViewBackground.setOnPreparedListener(mp -> mp.setLooping(true));
    }

    // Method to check if username and password are valid
    private boolean checkCredentials(String username, String password) {
        // Query the database to check if the user exists and if the password matches
        Cursor cursor = userDatabaseHelper.getUserByUsernameAndPassword(username, password);
        if (cursor != null && cursor.getCount() > 0) {
            // User found with the provided username and password
            cursor.close();
            return true;
        }
        return false; // User not found or password doesn't match
    }
}

