package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    private int movie_length;
    public Movie(String title,String genre,int realese_year,int duration,double rating,ArrayList<String> cast,int movie_length)
    {
        super(title,genre,realese_year,duration,rating,cast);
        this.movie_length = movie_length;
    }

    public int getMovie_length() {
        return movie_length;
    }

    public void setMovie_length(int movie_length) {
        this.movie_length = movie_length;
    }
}
