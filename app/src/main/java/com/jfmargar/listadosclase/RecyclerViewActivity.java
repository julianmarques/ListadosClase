package com.jfmargar.listadosclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.jfmargar.listadosclase.ui.Book;
import com.jfmargar.listadosclase.ui.BooksAdapter;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_FOR_NEW_BOOK = 1000;
    RecyclerView rvBooks;
    Button btnAdd;
    ArrayList<Book> books;
    private BooksAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //Inicializa la vista
        initView();
        //Luego genera los libros de ejemplo
        generateBooks();
        //Inicializa el listado (recyclerview)
        initRecyclerView();
    }

    /**
     * Este método inicializa un recyclerview
     */
    private void initRecyclerView() {
        adapter = new BooksAdapter(
                books,
                R.layout.book_item,
                RecyclerViewActivity.this);

        rvBooks.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                RecyclerViewActivity.this,
                LinearLayoutManager.VERTICAL,
                false);

        rvBooks.setLayoutManager(layoutManager);
    }

    private void generateBooks() {
        Book book1 = new Book();
        book1.setTitle("Juego de tronos");
        book1.setAuthor("G.R.R. Martin");
        book1.setSinopsis("Aquí muere Boromir");
        book1.setCover("https://images-na.ssl-images-amazon.com/images/I/51MK0TcanbL._SX328_BO1,204,203,200_.jpg");


        Book book2 = new Book();
        book2.setTitle("Choque de Reyes");
        book2.setAuthor("G.R.R. Martin");
        book2.setSinopsis("");
        book2.setCover("https://2.bp.blogspot.com/-h3IM1JgJIBU/UxhNBGJD2vI/AAAAAAAAA7g/CgE5w03ZQuY/s1600/Choque+de+reyes.jpg");

        Book book3 = new Book();
        book3.setTitle("Tormenta de espadas");
        book3.setAuthor("G.R.R. Martin");
        book3.setSinopsis("");
        book3.setCover("https://images-na.ssl-images-amazon.com/images/I/516aVS3Q68L._SX328_BO1,204,203,200_.jpg");

        Book book4 = new Book();
        book4.setTitle("Festín de cuervos");
        book4.setAuthor("G.R.R. Martin");
        book4.setSinopsis("");
        book4.setCover("https://images-na.ssl-images-amazon.com/images/I/51h9dVtHCRL._SX338_BO1,204,203,200_.jpg");

        Book book5 = new Book();
        book5.setTitle("Danza de dragones");
        book5.setAuthor("G.R.R. Martin");
        book5.setSinopsis("");
        book5.setCover("https://images-na.ssl-images-amazon.com/images/I/51RYlyN91oL._SX338_BO1,204,203,200_.jpg");

        Book book6 = new Book();
        book6.setTitle("Vientos de invierno");
        book6.setAuthor("G.R.R. Martin");
        book6.setSinopsis("");
        book6.setCover("https://d1n11wevxmtw6b.cloudfront.net/p/o/ca/32567713ad96fca.jpg");

        Book book7 = new Book();
        book7.setTitle("Sueños de primavera");
        book7.setAuthor("G.R.R. Martin");
        book7.setSinopsis("");
        book7.setCover("https://i.pinimg.com/236x/fb/d0/29/fbd029808bd1729e6a0c0c35ca72461c.jpg");

        books = new ArrayList<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
    }

    private void initView() {
        rvBooks = findViewById(R.id.rvBooks);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecyclerViewActivity.this, FormularioBookActivity.class);

                startActivityForResult(intent, REQUEST_CODE_FOR_NEW_BOOK);
//                Book book = new Book();
//                book.setTitle("Harry potter");
//                books.add(book);
//                adapter.notifyItemInserted(books.size() - 1);
//                rvBooks.scrollToPosition(books.size() -1);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Compruebo que la respuesta es correcta, que viene de donde espero que venga y que traiga información
        if (requestCode == REQUEST_CODE_FOR_NEW_BOOK && data != null) {

            Book book = (Book) data.getSerializableExtra("book");

            books.add(book);
            adapter.notifyItemInserted(books.size() - 1);
            rvBooks.scrollToPosition(books.size() - 1);


        }

    }
}
