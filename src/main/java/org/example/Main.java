package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    //don't limit yourself to our template ***
    private static NetflixService netflixService = new NetflixService();
    static String username;
    static String password;
    static String title;
    static String genre;
    static int year;
    static int duration;
    static int number;
    static double rating;
    public static void main(String[] args) {
        test();
        runMenu();
    }

    public static void test(){
        ArrayList<String> caster_test1 = new ArrayList<>();
        caster_test1.add("Al Pachino");
        caster_test1.add("Marlon Brando");
        TVShow test1 = new TVShow("The Godfather","Drama",1972,3,9.2,caster_test1);
        System.out.println(test1);
//        all_movie.add(test1);
        netflixService.addTVShow(test1);
        System.out.println(netflixService);
        ArrayList<String> caster_test2 = new ArrayList<>();
        caster_test2.add("Al Pachino");
        caster_test2.add("Robert Daniro");
        TVShow test2 = new TVShow("The Godfather 2","Drama",1974,3,9,caster_test2);
//        all_movie.add(test2);
        netflixService.addTVShow(test2);
        ArrayList<String> caster_test3 = new ArrayList<>();
        caster_test3.add("Gal Gadot");
        caster_test3.add("Dwayne Johnson");
        TVShow test3 = new TVShow("Red Notice","Action",2021,2,6.3,caster_test3);
//        all_movie.add(test3);
        netflixService.addTVShow(test3);
        ArrayList<String> caster_test4 = new ArrayList<>();
        caster_test4.add("Noomi Rapace");
        caster_test4.add("Jakob Oftebro");
        TVShow test4 = new TVShow("Black Crab","Action",2022,2,5.7,caster_test4);
//        all_movie.add(test4);
        netflixService.addTVShow(test4);
        ArrayList<String> caster_test5 = new ArrayList<>();
        caster_test5.add("Macaulay Culkin");
        caster_test5.add("Joe Pesci");
        caster_test5.add("Daniel Stern");
        TVShow test5 = new TVShow("Home Alone","Comedy",1990,2,7.7,caster_test5);
//        all_movie.add(test5);
        netflixService.addTVShow(test5);
        ArrayList<String> caster_test6 = new ArrayList<>();
        caster_test6.add("Jim Carrey");
        caster_test6.add("Jeff Danials");
        TVShow test6 = new TVShow("Dum & Dumber","Comedy",1994,2,7.3,caster_test6);
//        all_movie.add(test6);
        netflixService.addTVShow(test6);
        ArrayList<String> caster_test7 = new ArrayList<>();
        caster_test7.add("Kate Winslet");
        caster_test7.add("Leonardo Dicaprio");
        TVShow test7 = new TVShow("Titanic","Romance",1997,3,7.9,caster_test7);
//        all_movie.add(test7);
        netflixService.addTVShow(test7);
        ArrayList<String> caster_test8 = new ArrayList<>();
        caster_test8.add("Ryan Gosling");
        caster_test8.add("Rachel McAdams");
        TVShow test8 = new TVShow("NoteBook","Romance",2004,2,7.8,caster_test8);
//        all_movie.add(test8);
        netflixService.addTVShow(test8);
    }

    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println("Welcome to Netflix");
            System.out.println("1-Create account");
            System.out.println("2-Login");
            System.out.println("3-Logout");
            System.out.println("4-Add movie");
            System.out.println("5-Add TVShow");
            System.out.println("0-Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("PLS enter username");
                    username = scanner.nextLine();
                    System.out.println("PLS enter password");
                    password = scanner.nextLine();
                    netflixService.signUp(username, password);
                }
                case 2 -> {
                    System.out.println("PLS enter username");
                    username = scanner.nextLine();
                    System.out.println("PLS enter password");
                    password = scanner.nextLine();
                    if (netflixService.login(username, password)) {
                        ArrayList<TVShow> allTvShows = netflixService.get_all_tv_shows();
                        User currentUser = netflixService.getCurrent_user();
                        ArrayList<TVShow> recommend_video = currentUser.getRecommendations(allTvShows);
                        for (TVShow show : recommend_video) {
                            System.out.println(show.getTitle());
                        }
                        System.out.println("You can search movie & and TV Shows");
                        System.out.println("1-Search by title");
                        System.out.println("2-Search by genre");
                        System.out.println("3-Search by realese year");
                        System.out.println("4-Search your favorite movies & TV Shows");
                        System.out.println("5-Add Favorite Movie & TV Shows");
                        System.out.println("6-Watch Your Favorite List");
                        int search_choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (search_choice) {
                            case 1 -> {
                                System.out.println("Enter title:");
                                title = scanner.nextLine();
                                for (TVShow tvShow : netflixService.searchByTitle(title)){
                                    System.out.println(tvShow);
                                }
                            }
                            case 2 -> {
                                System.out.println("Enter genre:");
                                genre = scanner.nextLine();
                                netflixService.searchByGenre(genre);
                            }
                            case 3 -> {
                                System.out.println("Enter year:");
                                year = scanner.nextInt();
                                scanner.nextLine();
                                netflixService.searchByReleaseYear(year);
                            }
                            case 4 -> {
                                System.out.println("1-Search by title");
                                System.out.println("2-Search by genre");
                                System.out.println("3-Search by realese year");
                                int switch_case = scanner.nextInt();
                                switch (switch_case) {
                                    case 1 -> {
                                        System.out.println("Enter title:");
                                        title = scanner.nextLine();
                                        netflixService.getCurrent_user().searchByTitle(title);
                                    }
                                    case 2 -> {
                                        System.out.println("Enter genre:");
                                        genre = scanner.nextLine();
                                        netflixService.getCurrent_user().searchByGenre(genre);
                                    }
                                    case 3 -> {
                                        System.out.println("Enter year:");
                                        year = scanner.nextInt();
                                        scanner.nextLine();
                                        netflixService.getCurrent_user().searchByReleaseYear(year);
                                    }
                                }
                            }
                            case 5 -> {
                                System.out.println("Enter title:");
                                title = scanner.nextLine();
                                for (TVShow tv : netflixService.getCurrent_user().getFavorite_movie()) {
                                    if (!tv.getTitle().equals(title)) {
                                        netflixService.getCurrent_user().addToFavorites(tv);
                                    } else {
                                        System.out.println("THIS SHOW IN YOUR FAVORITE LIST ALREADY");
                                    }
                                }
                            }
                            case 6 -> {
                                System.out.println("Your Favorite List: ");
                                netflixService.getCurrent_user().viewFavorites();
                            }
                        }
                    }
                }
                case 3 -> netflixService.logout();
                case 4 ->{
                    System.out.println("PLS Enter title:");
                    title = scanner.nextLine();
                    System.out.println("PLS Enter genre:");
                    genre = scanner.nextLine();
                    System.out.println("PLS Enter year:");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("PLS Enter duration");
                    duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("PLS Enter rating");
                    rating = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("PLS Enter number of casters");
                    number = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("PLS Enter casters");
                    ArrayList<String> cast = new ArrayList<>();
                    for (int i=0;i<number;i++){
                        String cast_name = scanner.nextLine();
                        cast.add(cast_name);
                    }
                    TVShow new_add = new TVShow(title,genre,year,duration,rating,cast);
                    netflixService.addTVShow(new_add);
                }
                case 5 -> {
                    exit = false;
                    return;
                }
            }
        }
    }
}
