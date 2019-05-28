package com.jfmargar.listadosclase.data;

import com.jfmargar.listadosclase.data.dto.ListOfMoviesDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Julián Marqués on 2019-05-28.
 */
public interface MovieServices {

    @GET("movie/upcoming")
    Call<ListOfMoviesDTO> getUpcomingMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);
}
