package com.jfmargar.listadosclase.data;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Julián Marqués on 2019-05-28.
 */
public class RestClient {
    public static final int NOT_FOUND = 404;
    public static final int CONNECT_TIMEOUT = 20000;
    public static final int WRITE_TIMEOUT = 20000;
    public static final int READ_TIMEOUT = 20000;
    public static final int NOT_ACEPTED = 406;

    public static final String apiKey = "2cb88f6bdd09877db8127bcd6208914a";
    public static final String language = "en-US";
    //    https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg
    public static String imageBaseUrl = "https://image.tmdb.org/t/p/w500";
    MovieServices movieServices;
    /**
     * Url base de los servicios de la API
     */
    private String baseUrl = "https://api.themoviedb.org/3/";

    public RestClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);


        OkHttpClient client = okHttpClient.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        initServices(restAdapter);

    }

    public MovieServices getMovieServices() {
        return movieServices;
    }

    /**
     * Se encarga de iniciar e implementar nuestras llamadas
     *
     * @param restAdapter objeto retrofit
     */
    private void initServices(Retrofit restAdapter) {
        movieServices = restAdapter.create(MovieServices.class);

    }
}
