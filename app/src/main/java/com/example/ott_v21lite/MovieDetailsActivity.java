package com.example.ott_v21lite;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    private TextView textViewMovieTitle, textViewReleaseDate, textViewGenres, textViewDescription, textViewCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // Initialize TextViews
        textViewMovieTitle = findViewById(R.id.textViewMovieTitle);
        textViewReleaseDate = findViewById(R.id.textViewReleaseDate);
        textViewGenres = findViewById(R.id.textViewGenres);
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewCast = findViewById(R.id.textViewCast);

        // Get movie details from intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieTitle = extras.getString("movieTitle");
            displayMovieDetails(movieTitle);
        }
    }

    private void displayMovieDetails(String movieTitle) {
        // Here you can hardcode the movie details
        if ("Dune".equals(movieTitle)) {
            textViewMovieTitle.setText(movieTitle);
            textViewReleaseDate.setText("Release Date: October 22, 2021");
            textViewGenres.setText("Genres: Sci-Fi, Adventure");
            textViewDescription.setText("Description: A noble family becomes embroiled in a political and intergalactic conflict when they are entrusted with the protection of the most valuable asset in the galaxy.");
            textViewCast.setText("Cast: Timothée Chalamet, Rebecca Ferguson, Zendaya");
        } else if ("Inception".equals(movieTitle)) {
            textViewMovieTitle.setText(movieTitle);
            textViewReleaseDate.setText("Release Date: July 16, 2010");
            textViewGenres.setText("Genres: Sci-Fi, Action");
            textViewDescription.setText("Description: A thief who enters the dreams of others to steal secrets from their subconscious gets a chance to redeem himself by planting an idea in someone's mind.");
            textViewCast.setText("Cast: Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page");
        } else if ("Forest Gump".equals(movieTitle)) {
            textViewMovieTitle.setText(movieTitle);
            textViewReleaseDate.setText("Release Date: July 6, 1994");
            textViewGenres.setText("Genres: Drama, Romance");
            textViewDescription.setText("Description: The life journey of Forrest Gump, a man with a low IQ, and how he influences others' lives without realizing the impact he has because of his innocence.");
            textViewCast.setText("Cast: Tom Hanks, Robin Wright, Gary Sinise");
        }
    }
}
