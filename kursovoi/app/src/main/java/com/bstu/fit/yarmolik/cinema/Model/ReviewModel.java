package com.bstu.fit.yarmolik.cinema.Model;

public class ReviewModel {
    private String FilmId;

    public ReviewModel(String filmId) {
        FilmId = filmId;
    }

    public String getFilmId() {
        return FilmId;
    }

    public void setFilmId(String filmId) {
        FilmId = filmId;
    }
}
