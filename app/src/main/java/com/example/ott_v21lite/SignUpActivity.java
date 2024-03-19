package com.example.ott_v21lite;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextDOB;
    private EditText editTextEmail;
    private EditText editTextPhoneNumber;
    private Button buttonSignUp;
    private UserDatabaseHelper userDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize database helper
        userDatabaseHelper = new UserDatabaseHelper(this);

        // Initialize UI components
        editTextUsername = findViewById(R.id.editTextUsernameSignUp);
        editTextPassword = findViewById(R.id.editTextPasswordSignUp);
        editTextDOB = findViewById(R.id.editTextDOBSignUp);
        editTextEmail = findViewById(R.id.editTextEmailSignUp);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneSignUp);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        // Set click listener for sign-up button
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String dob = editTextDOB.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phoneNumber = editTextPhoneNumber.getText().toString().trim();

                // Insert user data into database
                boolean inserted = userDatabaseHelper.insertUserData(username, password, dob, email, phoneNumber);
                if (inserted) {
                    // Display success message
                    Toast.makeText(SignUpActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    // Finish activity and navigate back to login screen
                    finish();
                } else {
                    // Display error message
                    Toast.makeText(SignUpActivity.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up video background
        VideoView videoViewBackground = findViewById(R.id.videoViewBackground);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.loginbackgroud);
        videoViewBackground.setVideoURI(videoUri);
        videoViewBackground.start();
        videoViewBackground.setOnPreparedListener(mp -> mp.setLooping(true));
    }
}

