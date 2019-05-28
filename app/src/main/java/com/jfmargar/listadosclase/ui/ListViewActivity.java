package com.jfmargar.listadosclase.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jfmargar.listadosclase.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView lvDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvDatos = findViewById(R.id.lvDatos);

        ArrayList<String> datos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datos.add("Dato " + i);
        }

        ArrayAdapter<String> adapter = new
                ArrayAdapter<>(
                ListViewActivity.this,
                android.R.layout.simple_list_item_1,
                datos);

        lvDatos.setAdapter(adapter);

    }
}
