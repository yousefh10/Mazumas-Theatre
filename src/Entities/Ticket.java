package Entities;

import java.util.*;

public class Ticket {
       private int ticketnumber;
       private int seatnumber;
       private String moviename;
       private Date showtime;
       private double price;

       public Ticket(int ticketnumber, int seatnumber, String moviename, double price, Date showtime) {//Public constructor that gets the ticket 
                                                                                                      //with its ticketnumber, seatnumber, moviename, 
                                                                                                      //price, and showtime
              this.ticketnumber = ticketnumber;
              this.seatnumber = seatnumber;
              this.moviename = moviename;
              this.showtime = showtime;
              this.price = price;
       }

       public int getTicketNumber() {
              //gets ticket number
              return this.ticketnumber;
       }

       public int getSeatNumber() {
              //gets seat number
              return this.seatnumber;
       }

       public String getMovieName() {
              //get movie name
              return this.moviename;
       }

       public Date getShowTime() {
              //get showtime
              return this.showtime;
       }

       public double getPrice() {
              //get price
              return this.price;
       }
}