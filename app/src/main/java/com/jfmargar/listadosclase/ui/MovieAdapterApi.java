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
import com.jfmargar.listadosclase.data.RestClient;
import com.jfmargar.listadosclase.data.dto.MovieDTO;

import java.util.ArrayList;

public class MovieAdapterApi extends ArrayAdapter<MovieDTO> {

    ArrayList<MovieDTO> movies;
    int resource;

    public MovieAdapterApi(Context context,
                           int resource,
                           ArrayList<MovieDTO> objects) {

        super(context, resource, objects);
        this.resource = resource;
        this.movies = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        if (convertView == null) {
            //"Inflar" la View a partir del XML de un elemento de la lista
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(resource, null);

            holder = new ViewHolder();
            holder.tvTitulo = item.findViewById(R.id.tvTitulo);
            holder.tvSubtitulo = item.findViewById(R.id.tvSubtitulo);
            holder.ivPortada = item.findViewById(R.id.ivPortada);

            item.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MovieDTO movie = movies.get(position);

        holder.tvTitulo.setText(movie.getTitle());
//        holder.tvSubtitulo.setText(movie.getSubtitle());

        String url = RestClient.imageBaseUrl + movie.getPoster_path();
        Glide.with(getContext()).load(url).into(holder.ivPortada);

        return item;
    }

    static class ViewHolder {
        TextView tvTitulo;
        TextView tvSubtitulo;
        ImageView ivPortada;
    }
}
