package com.jfmargar.listadosclase.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jfmargar.listadosclase.R;
import com.jfmargar.listadosclase.data.RestClient;
import com.jfmargar.listadosclase.data.dto.ListOfMoviesDTO;
import com.jfmargar.listadosclase.data.dto.MovieDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoOptimizadoAPIActivity extends AppCompatActivity {

    ListView lvPeliculas;

    ArrayList<MovieDTO> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_optimizado_api);

        lvPeliculas = findViewById(R.id.lvPeliculas);

        final MovieAdapterApi adapter = new MovieAdapterApi(this, R.layout.movie_item, movies);

        lvPeliculas.setAdapter(adapter);


        Call<ListOfMoviesDTO> call = App.restClient.getMovieServices().getUpcomingMovies(RestClient.apiKey,
                RestClient.language,
                1);

        call.enqueue(new Callback<ListOfMoviesDTO>() {
            @Override
            public void onResponse(Call<ListOfMoviesDTO> call, Response<ListOfMoviesDTO> response) {

                movies.addAll(response.body().getResults());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ListOfMoviesDTO> call, Throwable t) {

            }
        });

    }
}
