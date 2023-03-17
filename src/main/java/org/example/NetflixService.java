package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    private ArrayList<User> users;
    private ArrayList<TVShow> tvShows;
    private ArrayList<Movie> movies;
    private User current_user;

    public NetflixService() {
        this.users = new ArrayList<>();
        this.tvShows = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.current_user = null;
    }

    public void addTVShow(TVShow tvShow){
        this.tvShows.add(tvShow);
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void signUp(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)){
                System.out.println("USERNAME ALREADY EXISTS");
                return;
            }
        }
        User new_user = new User(username,password);
        users.add(new_user);
        System.out.println("ACCOUNT CREATED SUCCESSFULLY");
    }

    public boolean login(String username, String password) {
        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                this.current_user = user;
                return true;
            }
        }
        System.out.println("INCORRECT USERNAME OR PASSWORD");
        return false;
    }

    public void logout() {
        if (this.current_user != null){
            this.current_user = null;
            System.out.println("LOGOUT SUCCESSFULLY");
        }
        else {
            System.out.println("NOT ANY USER LOGIN CURRENTLY");
        }
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> found_tv_show = new ArrayList<>();

        for (TVShow tvShow : this.tvShows){
            if (tvShow.getTitle().equals(title)){
                found_tv_show.add(tvShow);
            }
        }

        for (Movie movie : this.movies){
            if (movie.getTitle().equals(title)){
                found_tv_show.add(movie);
            }
        }
        return found_tv_show;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> found_tv_show = new ArrayList<>();

        for (TVShow tvShow : this.tvShows){
            if (tvShow.getGenre().equals(genre)){
                found_tv_show.add(tvShow);
            }
        }

        for (Movie movie : this.movies){
            if (movie.getGenre().equals(genre)){
                found_tv_show.add(movie);
            }
        }
        return found_tv_show;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> found_tv_show = new ArrayList<>();

        for (TVShow tvShow : this.tvShows){
            if (tvShow.getRealese_year()==year){
                found_tv_show.add(tvShow);
            }
        }

        for (Movie movie : this.movies){
            if (movie.getRealese_year() == year){
                found_tv_show.add(movie);
            }
        }
        return found_tv_show;
    }

    public User getCurrent_user() {
        return current_user;
    }

    @Override
    public String toString() {
        return "NetflixService{" +
                "users=" + users +
                ", tvShows=" + tvShows +
                ", movies=" + movies +
                ", current_user=" + current_user +
                '}';
    }

    public ArrayList<TVShow> get_all_tv_shows() {
        ArrayList<TVShow> all_tv_shows = new ArrayList<>();
        for (TVShow show : this.tvShows) {
            all_tv_shows.add(show);
        }
        return all_tv_shows;
    }
}