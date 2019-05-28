package com.jfmargar.listadosclase.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jfmargar.listadosclase.R;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {

    ArrayList<Movie> movies;
    int resource;

    public MovieAdapter(Context context,
                        int resource,
                        ArrayList<Movie> objects) {

        super(context, resource, objects);
        this.resource = resource;
        this.movies = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //"Inflar" la View a partir del XML de un elemento de la lista
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(resource, null);

        //Enlazar los elementos de la view con las variables java.
        TextView tvTitulo = item.findViewById(R.id.tvTitulo);
        TextView tvSubtitulo = item.findViewById(R.id.tvSubtitulo);
        ImageView ivPortada = item.findViewById(R.id.ivPortada);

        Movie movie = movies.get(position);

        tvTitulo.setText(movie.getTitle());
        tvSubtitulo.setText(movie.getSubtitle());

        Glide.with(getContext()).load(movie.getUrl()).into(ivPortada);

        return item;
    }
}
