package Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Database {
    private Connection connection;
    private PreparedStatement preparedstatement;
    private ResultSet resultset;

    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/movietheatre_db", "480", "123456789");
            //Connect to the database in order to access and store information in account, movies, tickets, reserved seats...etc.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to connect to database");
        }
    }

    public boolean FindMovie(String moviename) {
        //system finds the movie name that is inputted by the user in the GUI
        boolean found = false;
        String l_moviename = "";
        try {
            String query = "SELECT * FROM movietheatre_db.movie WHERE name = ?";
            //place all the movie names in a single string called query
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, moviename);
            resultset = preparedstatement.executeQuery();
            //convert the query into a result set in order to travesrse through all the movie names
            if (resultset.next()) {
                l_moviename = resultset.getString("name");
                if (l_moviename.equals(moviename)) {
                    //if the user movie input  equals to one of the movies in the database it will becometrue
                    found = true;
                } else {
                    found = false;
                }
            } else {
                found = false;
            }
            preparedstatement.close();
            resultset.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to find movie");
            //if there is no movie found then the system will display an error
        }
        Movie m = Movie.getInstance();
        m.setMoviename(l_moviename);
        return found;
    }


    public boolean AddGuest(Guest guest) {
        //Adds guest into the database and approves if added by boolean
        boolean added = false;
        try {
            String query = "INSERT INTO movietheatre_db.guest VALUES(?,?,?,?,?,?,?)";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, guest.getFname());
            preparedstatement.setString(2, guest.getLname());
            preparedstatement.setString(3, guest.getEmail());
            preparedstatement.setLong(4, guest.getCardnumber());
            preparedstatement.setInt(5, guest.getCvv());
            preparedstatement.setString(6, guest.getBilling());
            preparedstatement.setString(7, guest.getExpiration());
            added = preparedstatement.executeUpdate() >= 1;
            preparedstatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to add guest user");;
        }
        return added;
    }

    public boolean AddAccount(Account account) {
        //Adds Account into the database and approves if added by boolean
        boolean added = false;
        try {
            String query = "INSERT INTO movietheatre_db.account VALUES(?,?,?,?,?,?,?,?,?)";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, account.getFname());
            preparedstatement.setString(2, account.getLname());
            preparedstatement.setString(3, account.getUsername());
            preparedstatement.setString(4, account.getPassword());
            preparedstatement.setString(5, account.getEmail());
            preparedstatement.setLong(6, account.getCardnumber());
            preparedstatement.setInt(7, account.getCvv());
            preparedstatement.setString(8, account.getBilling());
            preparedstatement.setString(9, account.getExpiration());
            added = preparedstatement.executeUpdate() >= 1;
            preparedstatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to add account");
        }
        return added;
    }

    public boolean FindAccount(String username, String password) {
        //finds Account in the database and approves if found by boolean
        boolean found = false;
        try {
            String query = "SELECT * FROM movietheatre_db.account WHERE username = ? AND password = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);
            resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                String l_password = resultset.getString("password");
                if (l_password.equals(password)) {
                    found = true;
                } else {
                    found = false;
                }
            } else {
                found = false;
            }
            preparedstatement.close();
            resultset.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to find account");
        }
        return found;
    }

    public boolean RemoveAccount(String account) {
        //Removes account from the database and approves if removed by boolean
        boolean removed = false;
        try {
            String query = "DELETE FROM movietheatre_db.account WHERE username = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, account);
            removed = preparedstatement.executeUpdate() >= 1;
            preparedstatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to remove account");
        }
        return removed;
    }

    public boolean RemoveTicket(int ticket) {
        //Removes ticket from the database and approves if removed by boolean
        //This is done by the ticket number, and if its lets than 
        //72 hours before the show time then the removing of the ticket will become invalid
        boolean removed = false;
        String seats = "";
        ArrayList<Integer> seats_int = new ArrayList<Integer>();
        try {
            String query = "SELECT * FROM movietheatre_db.ticket WHERE ticketnumber = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, ticket);
            resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                seats = resultset.getString("seatnumber");
            }else{
                return false;
            }
            preparedstatement.close();
            resultset.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to remove ticket");
        }
        seats = seats.substring(0, seats.length() - 1);
        String seats_arr[] = seats.split(",");
        for (String s : seats_arr) {
            seats_int.add(Integer.parseInt(s));
        }
        try {
            String query = "DELETE FROM movietheatre_db.ticket WHERE ticketnumber = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, ticket);
            removed = preparedstatement.executeUpdate() >= 1;
            preparedstatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to remove ticket");
        }
        try {
            String query = "DELETE FROM movietheatre_db.seat WHERE seatnumber = ?";
            preparedstatement = connection.prepareStatement(query);
            for (int x = 0; x < seats_int.size(); x++) {
                preparedstatement.setInt(1, seats_int.get(x));
                removed = preparedstatement.executeUpdate() >= 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to remove ticket");
        }
        return removed;
    }

    public boolean AddMovie(String movie, String time) {
        //Adds movie into the database and approves if added by boolean
        boolean added = true;
        try {
            String query = "INSERT INTO movietheatre_db.movie VALUES (?,?)";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, movie);
            preparedstatement.setString(2, time);
            added = preparedstatement.executeUpdate() >= 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to add movie");;
        }
        return added;
    }

    public boolean RemoveMovie(String movie) {
        //removes movie from the database and approves if added by boolean
        boolean removed = false;
        try {
            String query = "DELETE FROM movietheatre_db.movie WHERE name = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, movie);
            removed = preparedstatement.executeUpdate() >= 1;
            preparedstatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to remove movie");;
        }
        return removed;
    }

    public void AddTicket(int ticketnumber, Movie m) {
        //Adds Ticket into the database and approves if added by boolean
        String seats = "";
        for (int i = 0; i < m.getSeats().size(); i++) {
            seats += (m.getSeats().get(i).getSeatNumber()) + ",";
        }
        try {
            String query = "INSERT INTO movietheatre_db.ticket VALUES(?,?,?,?,?)";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, ticketnumber);
            preparedstatement.setString(2, seats);
            preparedstatement.setString(3, m.getMoviename());
            preparedstatement.setFloat(4, m.getSeats().size() * 15);
            preparedstatement.setString(5, m.getScreentime());
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to add ticket");;
        }
    }

    public void AddSeat(Movie m) {
         //Adds Seat into the database and approves if added by boolean
        try {
            String query = "INSERT INTO movietheatre_db.seat VALUES (?,?,?,?)";
            preparedstatement = connection.prepareStatement(query);
            for (Seat seat : m.getSeats()) {
                preparedstatement.setInt(1, seat.getSeatNumber());
                preparedstatement.setBoolean(2, true);
                preparedstatement.setString(3, seat.getMovieName());
                preparedstatement.setString(4, seat.getShowTime());
                preparedstatement.executeUpdate();
            }
            preparedstatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to add seat");
        }
    }

    public Vector<Integer> GetSeats(String movie, String time) {
        //Gets Seats from the database and returns a vector list of all selected seats for a movie and its showtime
        Vector<Integer> seats = new Vector<Integer>();
        try {
            String query = "SELECT * FROM movietheatre_db.seat WHERE moviename = ? AND showtime = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, movie);
            preparedstatement.setString(2, time);
            resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                if (resultset.getBoolean("availability")) {
                    seats.add(resultset.getInt("seatnumber"));
                }
            }
            preparedstatement.close();
            resultset.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to get seat");
        }
        return seats;
    }

    public ArrayList<String> GetShowtime(String name) {
        //Gets Showtime from the database and returns a vector list of all selected seats for a movie and its screentime
        ArrayList<String> showtimes = new ArrayList<String>();
        String stime = "";
        try {
            String query = "SELECT * FROM movietheatre_db.movie WHERE name = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, name);
            resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                stime = resultset.getString("screentime");
                showtimes.add(stime);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to get showtime");
        }
        return showtimes;
    }

    public String GetRegisteredEmail(String username){
         //Gets Email from the database and returns a string of a registered email
        String email = "";
        try {
            String query = "SELECT * FROM movietheatre_db.account WHERE username = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, username);
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                email = resultset.getString("email");
            }
            preparedstatement.close();
            resultset.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to find user");
        }
        return email;
    }
    
    public String GetGuestEmail(String fname, String lname) {
        //gets guest email that is associated with a movie ticket and returns a email as a string
        String email = "";
        try {
            String query = "SELECT * FROM movietheatre_db.guest WHERE firstname = ? AND lastname = ?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, fname);
            preparedstatement.setString(2, lname);
            resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                email = resultset.getString("email");
            }
            preparedstatement.close();
            resultset.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to find user");
        }
        return email;
    }
    
}
