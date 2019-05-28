package com.jfmargar.listadosclase.data.dto;

/**
 * Created by Julián Marqués on 2019-05-28.
 */
public class MovieDTO {
    Long id;
    String title;
    String poster_path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
