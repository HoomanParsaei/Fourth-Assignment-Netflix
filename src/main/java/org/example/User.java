package org.example;

import java.util.*;
import java.util.stream.Collectors;

class User {
    /*
     * The user should contain username password.
     * The user should contain an ArrayList of favorite shows and watch history.
     * FUNCTION: the user should have a function to watch a show and add it to watch history.
     *  *** NOTE: All search functions in user are for searching in favorite shows ***
     */
    private String username;
    private String password;
    private ArrayList<TVShow> favorite_movie;
    private ArrayList<TVShow> watch_history;

    public User(String username, String password, ArrayList<TVShow> favorite_movie, ArrayList<TVShow> watch_history) {
        this.username = username;
        this.password = password;
        this.favorite_movie = favorite_movie;
        this.watch_history = watch_history;
    }

    public User(String username, String password) {
        this(username,password,new ArrayList<>(),new ArrayList<>());
    }

    public ArrayList<TVShow> getFavorite_movie() {
        return favorite_movie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> found_movie = new ArrayList<>();
        for (TVShow movie : favorite_movie){
            if (movie.getTitle().equals(title)){
                found_movie.add(movie);
            }
        }
        return found_movie;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> found_movie = new ArrayList<>();
        for (TVShow movie : favorite_movie){
            if (movie.getGenre().equals(genre)){
                found_movie.add(movie);
            }
        }
        return found_movie;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> found_movie = new ArrayList<>();
        for (TVShow movie : favorite_movie){
            if (movie.getRealese_year() == year){
                found_movie.add(movie);
            }
        }
        return found_movie;
    }
    public void addToFavorites(TVShow show) {
        if (!favorite_movie.contains(show)){
            favorite_movie.add(show);
        }
        else{
            System.out.println("THE SHOW EXISTS");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "favorite_movie=" + favorite_movie +
                '}';
    }

    public void viewFavorites() {
        if (favorite_movie.isEmpty()){
            System.out.println("Nothing in your favorite list");
        }
        else {
            toString();
        }
    }
    public void watch(TVShow show){
        watch_history.add(show);
        System.out.println("HISTORY OF WATCH: " + show.getTitle());
    }
    private class ScoreMovies{
        TVShow tvShow;
        float score;
        public ScoreMovies(TVShow tvShow, float score) {
            this.tvShow = tvShow;
            this.score = score;
        }
    }
    public ArrayList<TVShow> getRecommendations(ArrayList<TVShow> all_movie) {
        ArrayList<ScoreMovies> score_array  = new ArrayList<>();
        for (TVShow movie : all_movie){
            float score = get_recommendation_score(movie);
            ScoreMovies scoreMovie = new ScoreMovies(movie,score);
            score_array.add(scoreMovie);
        }
        score_array.sort(Comparator.comparingDouble(scoreMovie->scoreMovie.score));
        return score_array.stream().map(scoreMovie -> scoreMovie.tvShow).collect(Collectors.toCollection(ArrayList<TVShow>::new));                                    // Map it back to a string
    }

    public float get_recommendation_score(TVShow movie){
        float score = 0;
        for (TVShow movies : watch_history){
            if (movies.getGenre().equals(movie.getGenre())){
                score++;
            }
        }
        return score;
    }
}