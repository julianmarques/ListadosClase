package com.jfmargar.listadosclase.data.dto;

import java.util.ArrayList;

/**
 * Created by Julián Marqués on 2019-05-28.
 */
public class ListOfMoviesDTO {
    ArrayList<MovieDTO> results;

    public ArrayList<MovieDTO> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieDTO> results) {
        this.results = results;
    }
}
