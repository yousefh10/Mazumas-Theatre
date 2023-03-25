package Entities;

import java.util.*;
import java.text.*;

public class Showtime {
    private Date date;

    public Showtime(Date date) {//public constructor that adds a date to a showtime
        this.date = date;
    }

    public Date getDate() {//gets the date provided from the showtime
        return date;
    }

    public String toString() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm");//converts the date to a string
        String st = dt.format(date);
        return st;
    }
}
