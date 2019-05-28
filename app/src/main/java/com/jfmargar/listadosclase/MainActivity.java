package com.jfmargar.listadosclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnListView;
    Button btnListViewOptimizado;
    Button btnRecyclerView;
    Button btnGridView;
    Button btnPeliculas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListView = findViewById(R.id.btnListView);
        btnListViewOptimizado = findViewById(R.id.btnListViewOptimizado);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);
        btnPeliculas = findViewById(R.id.btnPeliculas);
        btnGridView = findViewById(R.id.btnGridView);

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

        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TablaPeliculasOptimizada.class);
                startActivity(intent);
            }
        });

    }
}
