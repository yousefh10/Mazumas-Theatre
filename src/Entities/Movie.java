package Entities;

import java.util.*;

public class Movie {
    private static Movie instance = null;
    private String moviename;
    private String screentime;
    private ArrayList<Seat> seats = new ArrayList<Seat>(25);
    private ArrayList<String> showtimes;

    private Movie() {
        //constructor movie
        this.moviename = null;
        this.screentime = null;
    }

    public static Movie getInstance() {
        //returns the movie instance
        if (instance == null) {
            instance = new Movie();
        }
        return instance;
    }

    public String getMoviename() {
        //gets movie
        return this.moviename;
    }

    public void setMoviename(String moviename) {
        //sets a movie name
        this.moviename = moviename;
    }

    public String getScreentime() {
        //get screentime
        return this.screentime;
    }

    public void setScreentime(String screentime) {
        //set screentime
        this.screentime = screentime;
    }

    public ArrayList<Seat> getSeats() {
        //get seats and return an arraylist of seats
        return this.seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        //set seats using an arraylist seats
        this.seats = seats;
    }

    public ArrayList<String> getShowtimes() {
        //gets the showtimes and returns an arraylist string
        return this.showtimes;
    }

    public void setShowtimes(ArrayList<String> showtimes) {
        //set showtimes using an arraylist string
        this.showtimes = showtimes;
    }

    public void addSeats(Vector<Integer> res) {
        //add seats using a vector integer
        if (seats == null) {
            seats = new ArrayList<Seat>(25);
        }
        //loops through each variable seat
        res.forEach((i) -> {
            seats.add(new Seat(i, false, moviename, screentime));
        });
    }

    @Override
    public String toString() {
        String s = " moviename='" + getMoviename() + "'" +
                ", screentime='" + getScreentime() + "'" +
                ", seats='";
        ;
        for (Seat seat : seats) {
            s += seat.getSeatNumber() + " ";
        }
        return s;
    }

}
