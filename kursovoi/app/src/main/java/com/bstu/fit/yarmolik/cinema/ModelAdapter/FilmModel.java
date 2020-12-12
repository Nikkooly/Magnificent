package com.bstu.fit.yarmolik.cinema.ModelAdapter;

import android.graphics.Bitmap;

public class FilmModel {
     private String name;
     private String genre;
     private Float rating;
     private String id;
     //Bitmap image;
     private String link;
    public FilmModel(String name, String genre, Float rating,String link, String id){// Bitmap image){
        this.name=name;
        //this.image=image;
        this.link=link;
        this.genre=genre;
        this.rating=rating;
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /*public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }*/

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
