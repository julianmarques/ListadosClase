package com.jfmargar.listadosclase.ui;

import android.app.Application;

import com.jfmargar.listadosclase.data.RestClient;

/**
 * Created by Julián Marqués on 2019-05-28.
 */
public class App extends Application {
    static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();

        restClient = new RestClient();

    }
}
