package com.example.ott_v21lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView moviePoster1 = findViewById(R.id.moviePoster1);
        ImageView moviePoster2 = findViewById(R.id.moviePoster2);
        ImageView moviePoster3 = findViewById(R.id.moviePoster3);

        // Set click listeners for movie posters
        moviePoster1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to details page with details of movie 1
                startActivity(new Intent(HomeActivity.this, DetailsActivity.class)
                                .putExtra("movieTitle", "Movie 1")
                                .putExtra("movieGenre", "Action")
                        // Add more movie details as needed
                );
            }
        });

        moviePoster2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to details page with details of movie 2
                startActivity(new Intent(HomeActivity.this, DetailsActivity.class)
                                .putExtra("movieTitle", "Movie 2")
                                .putExtra("movieGenre", "Comedy")
                        // Add more movie details as needed
                );
            }
        });

        moviePoster3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to details page with details of movie 3
                startActivity(new Intent(HomeActivity.this, DetailsActivity.class)
                                .putExtra("movieTitle", "Movie 3")
                                .putExtra("movieGenre", "Drama")
                        // Add more movie details as needed
                );
            }
        });
    }
}
