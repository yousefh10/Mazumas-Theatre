package GUI;

import javax.swing.*;

import Entities.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TicketSummary implements ActionListener { // Display ticket num seat num and movie name and showtime and
                                                       // price
    private JFrame frame = new JFrame(); // create new frame
    private JPanel panel = new JPanel(); // create new panel
    private JPanel bottomPanel = new JPanel(); // create new panel
    private JButton backToMainMenu = new JButton("Return to Main Menu"); // button to return to main menu
    private JButton exitProg = new JButton("Exit Program"); // button to exit program
    private JLabel dateLabel; // label to display date

    TicketSummary(Vector<Integer> reserved) { // constructor
        frame.setBackground(Color.green); // set top of frame to green
        Database db = new Database(); // create new database object
        String mailed = ""; // string to hold whether ticket was mailed or not
        Calendar cal = Calendar.getInstance(); // create new calendar object
        dateLabel = new JLabel("\t" + cal.getTime().toString()); // set date label to current date
        backToMainMenu.addActionListener(this); // this adds a actionlistener to main menu button
        exitProg.addActionListener(this); // this adds a actionlistener to exit program button
        Random rand = new Random(); // create new random object
        Integer num = rand.nextInt((9999999 - 10000) + 1) + 10000; // generate random number between 10000 and 9999999
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // set panel to a box layout
        bottomPanel.setLayout(new FlowLayout()); // set bottom panel to a flow layout
        panel.add(new JLabel( // add label to panel
                String.format("\tTransaction Number: %d", num))); // set label to transaction number
        mailed += String.format("\tTransaction Number: %d\n", num); // add transaction number to string
        // add ticket to db here
        if (reserved.size() == 1) { // if user reserved one ticket
            panel.add(new JLabel( // add label to panel
                    String.format("\tSeat Number: %d", reserved.get(0)))); // set label to seat number
            mailed += (String.format("\tSeat Number: %d\n", reserved.get(0))); // add seat number to string
        } else {
            for (int i = 0; i < reserved.size(); i++) { // for each seat number in vector
                panel.add(new JLabel( // add label to panel
                        String.format("\tSeat Number %d: %d", i + 1, reserved.get(i)))); // set label to seat number
                mailed += (String.format("\tSeat Number %d: %d\n", i + 1, reserved.get(i))); // add seat number to
                                                                                             // string
            }
        }
        panel.add(new JLabel("\tMovie Name: " + BookMovie.movie.getMoviename())); // add label to panel
        mailed += ("\tMovie Name: " + BookMovie.movie.getMoviename() + "\n"); // add movie name to string
        panel.add(new JLabel("\tShowtime: " + BookMovie.movie.getScreentime() + "          ")); // add label to panel
        mailed += ("\tShowtime: " + BookMovie.movie.getScreentime() + " \n"); // add showtime to string
        panel.add(new JLabel("\tTheatre Name: Mazumas' Theatre")); // add label to panel
        mailed += ("\tTheatre Name: Mazumas' Theatre\n"); // add theatre name to string
        panel.add(new JLabel("  ")); // add label to panel
        panel.add(new JLabel( // add label to panel
                "\tPrice: " + reserved.size() + " x $15")); // set label to price
        mailed += ("\tPrice: " + reserved.size() + " x $15\n"); // add price to string
        panel.add(new JLabel("\tTotal Price: $" + reserved.size() * 15)); // add label to panel
        mailed += ("\tTotal Price: $" + reserved.size() * 15 + "\n"); // add total price to string
        panel.add(new JLabel("  ")); // add label to panel
        panel.add(new JLabel("\tThank you for booking with us. Please keep track of the transaction")); // add label to
                                                                                                        // panel
        mailed += ("\tThank you for booking with us. Please keep track of the transaction"); // add string to string
        panel.add(new JLabel("\tnumber in the case you would like to cancel your booking.")); // add label to panel
        mailed += (" number in the case you would like to cancel your booking.\n"); // add string to string
        panel.add(new JLabel("  ")); // add label to panel
        mailed += "\t" + cal.getTime().toString(); // add date to string
        panel.add(dateLabel); // add label to panel
        bottomPanel.add(backToMainMenu); // add button to panel
        bottomPanel.add(exitProg); // add button to panel
        frame.add(panel, BorderLayout.CENTER); // add panel to frame
        frame.add(bottomPanel, BorderLayout.PAGE_END); // add panel to frame
        frame.setTitle("\tTicket Summary"); // set title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation
        frame.setSize(450, 350); // set size of frame
        frame.setVisible(true); // set frame to visible
        frame.setResizable(false); // set frame to not resizable
        frame.setLocationRelativeTo(null); // set frame to center of screen
        db.AddTicket(num, BookMovie.movie); // add ticket to db
        String email; // string to hold email
        if (MainGUI.button.compareTo("logged") == 0) { // if user is logged in
            email = db.GetRegisteredEmail(MainGUI.user); // get email from db
        } else { // if user is not logged in
            email = db.GetGuestEmail(GuestBilling.first, GuestBilling.last); // get email from db
        }
        EmailSender mail = new EmailSender("smtp.gmail.com", "issam15583", // create new email sender object
                "jyhwzquoszmwpnci", // email password
                email, "Mazuma's Theatre Reservation", mailed); // set email, subject, and body
        mail.sendEmail(); // send email
    }

    @Override // override action performed method
    public void actionPerformed(ActionEvent e) { // action performed method
        if (e.getSource().equals(exitProg)) { // if exit program button is pressed
            if (JOptionPane.showConfirmDialog(null, // This shows a confirm dialog box
                    "Are you sure you want to exit?", "Confirm exit", // asking the user if they are sure they want to
                                                                      // exit
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { // if yes is pressed
                System.exit(0); // exit program
            }
        }
        if (e.getSource().equals(backToMainMenu)) { // if back to main menu button is pressed
            frame.dispose(); // dispose of frame
            new MainGUI(); // create new main gui
        }
    }
}
