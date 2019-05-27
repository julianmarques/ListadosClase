package com.jfmargar.listadosclase;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {

    ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.movie_item, movies);
        this.movies = movies;
    }


    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        //"Inflar" una vista a partir de un xml
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.movie_item, null);

        ImageView ivPortada = item.findViewById(R.id.ivPortada);
        TextView tvTitulo = item.findViewById(R.id.tvTitulo);
        TextView tvSubtitulo = item.findViewById(R.id.tvSubtitulo);


        Movie movie = movies.get(position);

        tvTitulo.setText(movie.getTitle());
        tvSubtitulo.setText(movie.getSubtitle());

        String urlPortada = movie.getUrl();

        Glide.with(getContext()).load(urlPortada).into(ivPortada);


        return item;
    }
}
