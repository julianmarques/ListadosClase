package com.jfmargar.listadosclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jfmargar.listadosclase.ui.Book;

public class FormularioBookActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etAuthor;
    EditText etUrl;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_book);

        etNombre = findViewById(R.id.etNombre);
        etAuthor = findViewById(R.id.etAuthor);
        etUrl = findViewById(R.id.etUrl);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea el libro
                Book book = new Book();
                //Rellena el libro
                book.setTitle(etNombre.getText().toString());
                book.setAuthor(etAuthor.getText().toString());
                book.setCover(etUrl.getText().toString());

                //Crea el intent para volver atrás
                Intent intent = new Intent(FormularioBookActivity.this, RecyclerViewActivity.class);
                //Guarda dentro del intent el libro
                intent.putExtra("book", book);

                //Avisa de cual será el resultado
                setResult(RecyclerViewActivity.REQUEST_CODE_FOR_NEW_BOOK, intent);
                //Se cierra
                finish();


            }
        });


    }
}
