package Entities;

public class Seat {
    private int seatnumber;
    private boolean availability;
    private String moviename;
    private String showtime;

    public Seat(int seatnumber, boolean availability, String moviename, String showtime) {
        //public constructor for seat when system adds a new showtime, availabilty, or movie
        this.seatnumber = seatnumber;
        this.availability = availability;
        this.moviename = moviename;
        this.showtime = showtime;
    }

    public int getSeatNumber() {
        //returns an integer of a specific seat
        return this.seatnumber;
    }

    public boolean getAvailability() {
        //checks availability of seat
        return this.availability;
    }

    public String getMovieName() {
        //gets the name of the movie
        return this.moviename;
    }

    public String getShowTime() {
        //gets the showtime of the movie
        return this.showtime;
    }

}
