package org.example;

import java.util.ArrayList;

class TVShow {
    /*
     *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */
    private String title;
    private String genre;
    private int realese_year;
    private int duration;
    private double rating;
    private ArrayList<String> cast;

    public TVShow(String title, String genre, int realese_year, int duration, double rating, ArrayList<String> cast) {
        this.title = title;
        this.genre = genre;
        this.realese_year = realese_year;
        this.duration = duration;
        this.rating = rating;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRealese_year() {
        return realese_year;
    }

    public void setRealese_year(int realese_year) {
        this.realese_year = realese_year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void add_cast_member(String cast_member){
        cast.add(cast_member);
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", realese_year=" + realese_year +
                ", duration=" + duration +
                ", rating=" + rating +
                ", cast=" + cast +
                '}';
    }
}