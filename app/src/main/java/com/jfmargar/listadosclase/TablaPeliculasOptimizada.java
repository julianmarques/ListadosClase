package com.jfmargar.listadosclase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class TablaPeliculasOptimizada extends AppCompatActivity {

    GridView gvPelicuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_peliculas_optimizada);

        gvPelicuas = findViewById(R.id.gvPelicuas);

        Movie movie1 = new Movie();
        movie1.setTitle("Los vengadores: Infinity War");
        movie1.setSubtitle("Fase 2");
        movie1.setUrl("https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/9/94/Avengers_Infinity_War_-_Póster_oficial.png/revision/latest?cb=20180318000218&path-prefix=es");

        Movie movie2 = new Movie();
        movie2.setTitle("Robin Hoold");
        movie2.setUrl("https://images-na.ssl-images-amazon.com/images/I/91FR8gN8zOL._SY445_.jpg");

        Movie movie3 = new Movie();
        movie3.setTitle("Mula");
        movie3.setUrl("https://image.tmdb.org/t/p/w600_and_h900_bestv2/r7tJH9dXbHUHFF9ziACg3ELc2TC.jpg");

        Movie movie4 = new Movie();
        movie4.setTitle("Aquaman");
        movie4.setUrl("https://image.tmdb.org/t/p/w600_and_h900_bestv2/bPl0T5ndVdej6ewJHf0oHCTU7en.jpg");

        Movie movie5 = new Movie();
        movie5.setTitle("Bumblebee");
        movie5.setUrl("https://image.tmdb.org/t/p/w600_and_h900_bestv2/lOW8vBMJqWHWcMxHbigVAytqiBn.jpg");

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);


        MovieAdapter adapter = new MovieAdapter(this, R.layout.movie_item_2, movies);

        gvPelicuas.setAdapter(adapter);
    }
}
