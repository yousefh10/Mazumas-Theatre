package GUI;

import javax.swing.*;

import Entities.Database;
// import Entities.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;

public class SeatSelection implements ActionListener {

    private JFrame frame = new JFrame(); // create new frame
    private ArrayList<JButton> seatsButtons = new ArrayList<JButton>(25); // create new arraylist of buttons
    // create images using get resource method to get image from resources folder
    // for jar file
    private ImageIcon green = new ImageIcon(getClass().getResource("/images/green.jpeg")); // create new imageicon
    private ImageIcon white = new ImageIcon(getClass().getResource("/images/seat.jpeg")); // create new imageicon
    private ImageIcon black = new ImageIcon(getClass().getResource("/images/booked.jpeg")); // create new imageicon
    private JButton confirm = new JButton("Confirm Seat"); // create new button
    private Vector<Integer> reserved = new Vector<>(4); // create new vector of integers
    private Vector<Integer> booked = new Vector<>(4); // create new vector of integers
    private JPanel seatPanel = new JPanel(); // create new panel
    private JPanel bottomPanel = new JPanel(); // create new panel
    private JPanel msgPanel = new JPanel(); // create new panel

    private JLabel message = new JLabel("Select your seat below:"); // create new label

    SeatSelection() { // constructor
        seatPanel.setLayout(new FlowLayout()); // set layout to flow layout
        for (int i = 0; i < 25; i++) { // loop through 25 times
            JButton seat = new JButton(new ImageIcon(getClass().getResource("/images/seat.jpeg"))); // create new button
            seatsButtons.add(i, seat); // add button to arraylist
            seat.addActionListener(this); // add action listener to button
            seat.setPreferredSize(new Dimension(80, 80)); // set size of button
            seatPanel.add(seat); // add button to panel
        }
        if (MainGUI.button.compareTo("guest") == 0) { // if isnt logged in and cant access these seats
            seatsButtons.get(21).setIcon(new ImageIcon(getClass().getResource("/images/red.jpeg"))); // set icon of
                                                                                                     // button
            seatsButtons.get(22).setIcon(new ImageIcon(getClass().getResource("/images/red.jpeg"))); // set icon of
                                                                                                     // button
            seatsButtons.get(23).setIcon(new ImageIcon(getClass().getResource("/images/red.jpeg"))); // set icon of
                                                                                                     // button
        }
        // set booked from db here
        Database db = new Database(); // create new database
        booked = db.GetSeats(BookMovie.movie.getMoviename(), BookMovie.movie.getScreentime()); // get seats from db
        for (Integer i : booked) { // loop through booked
            seatsButtons.get(i).setIcon(new ImageIcon(getClass().getResource("/images/booked.jpeg"))); // set icon of
                                                                                                       // button
        }
        confirm.addActionListener(this); // add action listener to button
        msgPanel.add(message); // add label to panel
        bottomPanel.add(confirm); // add button to panel

        frame.setTitle("Select seats"); // set title of frame
        frame.add(msgPanel, BorderLayout.NORTH); // add panel to frame
        frame.add(seatPanel, BorderLayout.CENTER); // add panel to frame
        frame.add(bottomPanel, BorderLayout.PAGE_END); // add panel to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation
        frame.setSize(450, 600); // set size of frame
        frame.setVisible(true); // set frame to visible
        frame.setResizable(false); // set frame to not resizable
        frame.setBackground(Color.green); // set background color of frame
        frame.setLocationRelativeTo(null); // set location of frame to center of screen
    }

    @Override
    public void actionPerformed(ActionEvent e) { // action performed method
        int i = seatsButtons.indexOf(e.getSource()); // get index of button
        if (e.getSource().equals(confirm)) { // if button is confirm
            frame.dispose(); // dispose of frame
            if (MainGUI.button.compareTo("guest") == 0) { // if guest
                if (JOptionPane.showConfirmDialog(frame, // This shows a confirm dialog box
                        "You are going to reserve Seats: "
                                + reserved.toString().substring(1, reserved.toString().length() - 1), // message
                        "Confirm Seats",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    BookMovie.movie.getSeats().clear(); // set seats
                    BookMovie.movie.addSeats(reserved); // add seats to movie
                    Database db = new Database(); // create new database
                    
                    db.AddSeat(BookMovie.movie); // add seat to db
                    new GuestBilling(reserved); // create new guest billing
                } else {
                    new SeatSelection(); // create new seat selection
                }
            }
            if (MainGUI.button.compareTo("logged") == 0) { // if logged in
                if (JOptionPane.showConfirmDialog(frame, // This shows a confirm dialog box
                        "You are going to reserve Seats: "
                                + reserved.toString().substring(1, reserved.toString().length() - 1),
                        "Confirm Seats",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    BookMovie.movie.getSeats().clear(); // set seats
                    BookMovie.movie.addSeats(reserved); // add seats to movie
                    // add seats to db
                    Database db = new Database(); // create new database
                    db.AddSeat(BookMovie.movie); // add seat to db
                    new TicketSummary(reserved); // create new ticket summary
                } else {
                    new SeatSelection(); // create new seat selection
                }
            }
        }
        if (i != -1) {// if the source is a button
            if (MainGUI.button.compareTo("guest") == 0 && (i == 21 || i == 22 || i == 23)) {// reserved seats
                JOptionPane.showMessageDialog(frame, "These seats are for registered users only",
                        "Invalid Seat Selection", -1);
            } else if (seatsButtons.get(i).getIcon().toString().compareTo(black.toString()) == 0) {
                JOptionPane.showMessageDialog(frame, "This seat has already been booked",
                        "Seat Selection Full", -1);
            } else if (seatsButtons.get(i).getIcon().toString().compareTo(white.toString()) == 0) { // if the seat hasnt
                                                                                                    // been selected
                if (reserved.size() == 4) { // check if the reserves are full
                    JOptionPane.showMessageDialog(frame, "You have selected a maximum of 4 seats, please deselect",
                            "Seat Selection Full", -1);
                } else {// change to the green icon
                    seatsButtons.get(i).setIcon(new ImageIcon(getClass().getResource("/images/green.jpeg")));
                    reserved.add(i);
                }
            } else if (seatsButtons.get(i).getIcon().toString().compareTo(green.toString()) == 0) {// change to regular
                                                                                                   // seat
                seatsButtons.get(i).setIcon(new ImageIcon(getClass().getResource("/images/seat.jpeg")));
                reserved.removeElement(i);
            }

        }
    }
}
