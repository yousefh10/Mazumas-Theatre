package GUI;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class RegisteredMenu implements ActionListener {

    public static String button; // flag to see if user is registered or guest
    private JFrame frame = new JFrame(); // create new frame
    private JButton cancelBooking = new JButton("Cancel Booking"); // button to cancel booking
    private JButton bookMovie = new JButton("Book Movie"); // button to book movie
    private JButton movieNews = new JButton("Movie News"); // button to view movie news
    private JButton exitProg = new JButton("Exit Program"); // button to exit program

    private JPanel bottomPanel = new JPanel(); // panel to hold buttons at bottom of screen
    private JPanel messagePanel = new JPanel(); // panel to hold message label

    private JLabel message = new JLabel("Select an option:"); // message displayed to user

    RegisteredMenu() {
        cancelBooking.addActionListener(this); // this adds a actionlistener to cancel booking button
        bookMovie.addActionListener(this); // this adds a actionlistener to book movie button
        movieNews.addActionListener(this); // this adds a actionlistener to movie news button
        exitProg.addActionListener(this); // this adds a actionlistener to exit program button
        frame.setBackground(Color.green); // set top of frame to green
        bottomPanel.setLayout(new FlowLayout()); // set bottom panel to a flow layout
        bottomPanel.add(bookMovie); // add the book movie button to the bottom panel
        bottomPanel.add(movieNews); // add the movie news button to the bottom panel
        bottomPanel.add(cancelBooking); // add the cancel booking button to the bottom panel
        bottomPanel.add(exitProg); // add the exit button to the bottom panel

        messagePanel.setLayout(new FlowLayout()); // set main panel to a flow layout
        messagePanel.add(message); // add message to main panel

        frame.setTitle("Main Menu"); // set title of frame to main menu
        frame.add(bottomPanel, BorderLayout.PAGE_END); // set the bottom panel to bottom of screen
        frame.add(messagePanel, BorderLayout.PAGE_START); // set the main panel to top of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit if user closes frame
        frame.setSize(600, 150); // set size of frame
        frame.setVisible(true); // set frame visible to user
        frame.setResizable(false); // set frame so user cannot resize it
        frame.setLocationRelativeTo(null); // set frame to center of screen
    }

    @Override
    public void actionPerformed(ActionEvent e) { // if user clicks a button
        if (e.getSource().equals(cancelBooking)) { // if user clicks cancel booking button
            frame.dispose(); // dispose of current frame
            MainGUI.button = "logged"; // set button flag to logged
            new CancelBooking(); // open cancel booking menu
        }
        if (e.getSource().equals(exitProg)) { // if user clicks exit program button
            if (JOptionPane.showConfirmDialog(null, // This shows a confirm dialog box
                    "Are you sure you want to exit?", "Confirm exit",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0); // exit program
            }
        }
        if (e.getSource().equals(bookMovie)) { // if user clicks book movie button
            frame.dispose(); // dispose of current frame
            MainGUI.button = "logged"; // set button flag to logged
            new BookMovie(); // open book movie menu
        }
        if (e.getSource().equals(movieNews)) { // if user clicks movie news button
            frame.dispose(); // dispose of current frame
            MainGUI.button = "logged"; // set button flag to logged
            new MovieNews(); // open movie news menu
        }
    }
}