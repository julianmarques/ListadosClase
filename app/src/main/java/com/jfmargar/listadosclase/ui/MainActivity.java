package com.jfmargar.listadosclase.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jfmargar.listadosclase.R;

public class MainActivity extends AppCompatActivity {

    Button btnListView;
    Button btnListViewOptimizado;
    Button btnRecyclerView;
    Button btnApi;
    Button btnPeliculas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListView = findViewById(R.id.btnListView);
        btnListViewOptimizado = findViewById(R.id.btnListViewOptimizado);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);
        btnPeliculas = findViewById(R.id.btnPeliculas);
        btnApi = findViewById(R.id.btnApi);

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí ponemos la lógica del evento
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        btnPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListadoPeliculasActivity.class);
                startActivity(intent);
            }
        });

        btnListViewOptimizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListadoPeliculasOptimizadoActivity.class);
                startActivity(intent);
            }
        });

        btnApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListadoOptimizadoAPIActivity.class);
                startActivity(intent);
            }
        });

    }
}
