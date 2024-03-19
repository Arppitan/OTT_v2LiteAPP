package com.example.ott_v21lite;



import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example: Navigate to LoginActivity when the app starts
        startActivity(new Intent(this, LoginActivity.class));
        finish(); // Finish MainActivity to prevent going back to it with back button
    }
}
