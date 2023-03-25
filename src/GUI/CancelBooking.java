package GUI;

import javax.swing.*;

import Entities.Database;
import Entities.EmailSender;
import Entities.Ticket;

import java.awt.event.*;
import java.awt.*;

public class CancelBooking implements ActionListener { // class
    private JFrame frame = new JFrame(); // create new frame
    Ticket ticket; // create new ticket
    private JPanel bookingPanel = new JPanel(); // create new panel
    private JPanel bottomPanel = new JPanel(); // create new panel

    private JButton confirmCancel = new JButton("Confirm Cancellation"); // create new button
    private JButton undo = new JButton("Back"); // create new button

    private JTextField bookingID = new JTextField(); // create new textfield

    private JLabel bookingLabel = new JLabel("Enter Transaction Number:"); // create new label

    CancelBooking() {
        frame.setBackground(Color.green); // set top of frame to green
        confirmCancel.addActionListener(this); // this adds a actionlistener to main menu button
        undo.addActionListener(this); // this adds a actionlistener to login button

        bookingID.setColumns(8); // set number of columns in username text field

        bookingPanel.setLayout(new FlowLayout()); // set button panel to a flow layout
        bookingPanel.add(bookingLabel); // add the login button to the button panel
        bookingPanel.add(bookingID); // add the main menu button to the button panel

        bottomPanel.setLayout(new FlowLayout()); // set button panel to a flow layout
        bottomPanel.add(confirmCancel); // add the login button to the button panel
        bottomPanel.add(undo); // add the main menu button to the button panel

        frame.setTitle("Cancel Booking"); // set title of frame to login
        frame.add(bookingPanel, BorderLayout.CENTER); // set the user panel to top of screen
        frame.add(bottomPanel, BorderLayout.PAGE_END); // set the pass panel to center of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit if user closes frame
        frame.setSize(400, 220); // set size of frame
        frame.setVisible(true); // set frame visible to user
        frame.setLocationRelativeTo(null); // set frame to center of screen
    }

    public boolean checkInputs() { // method to check if user input is valid
        int l_ticketnumber = 0; // create new int
        try {
            l_ticketnumber = Integer.parseInt(bookingID.getText()); // get user input for username
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter an number"); // show error message
            return false; // return false
        }
        Database db = new Database(); // create new database
        if (!db.RemoveTicket(l_ticketnumber)) { // if ticket number is not in database
            JOptionPane.showMessageDialog(null, "Transaction number does not exist"); // show error message
            return false; // return false
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) { // method to handle button clicks
        if (e.getSource().equals(undo)) { // if user clicks login button
            frame.dispose(); // close frame
            if (MainGUI.button.compareTo("logged") == 0) { // if user is logged in
                new RegisteredMenu(); // open registered menu
            } else { // if user is not logged in
                new MainGUI(); // open main menu
            }
        } else if (e.getSource().equals(confirmCancel) && checkInputs()) { // if user clicks main menu button
            frame.dispose(); // close frame
            Database db = new Database(); // create new database
            String email; // create new string
            if (MainGUI.button.compareTo("logged") == 0) { // if user is logged in
                email = db.GetRegisteredEmail(MainGUI.user); // get email from database
            } else { // if user is not logged in
                email = db.GetGuestEmail(GuestBilling.first, GuestBilling.last); // get email from database
            }
            if (MainGUI.button.compareTo("logged") == 0) { // if user is logged in
                EmailSender mail = new EmailSender("smtp.gmail.com", "issam15583",
                        "jyhwzquoszmwpnci",
                        email, "Mazuma's Theatre Reservation", "Your Ticket has been cancelled :(");
                mail.sendEmail(); // send email
                new CancellationConfirmed(); // open cancellation confirmed
            } else { // if user is not logged in
                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to cancel? You will be charged a 15% \nadmin fee as you are not a registered user.",
                        "Confirm Cancel",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    new CancellationConfirmed(); // open cancellation confirmed
                } else { // if user clicks no
                    new CancelBooking(); // open cancel booking
                }
            }
        }
    }
}
