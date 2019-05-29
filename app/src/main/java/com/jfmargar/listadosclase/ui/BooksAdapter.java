package com.jfmargar.listadosclase.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jfmargar.listadosclase.R;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    ArrayList<Book> books;
    int resource;
    Context context;


    public BooksAdapter(ArrayList<Book> books, int resource, Context context) {
        this.books = books;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(resource, viewGroup, false);

        BookViewHolder vh = new BookViewHolder(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        Book book = books.get(i);
        bookViewHolder.bindBook(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvAuthor;
        TextView tvSinopsis;
        ImageView ivCover;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvSinopsis = itemView.findViewById(R.id.tvSinopsis);
            ivCover = itemView.findViewById(R.id.ivCover);
        }

        public void bindBook(Book book) {
            tvTitle.setText(book.getTitle());
            tvAuthor.setText(book.getAuthor());
            tvSinopsis.setText(book.getSinopsis());

            Glide.with(context).load(book.getCover()).into(ivCover);
        }
    }

}
