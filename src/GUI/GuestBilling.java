package GUI;

import javax.swing.*;

import Entities.Database;
import Entities.Guest;

import java.awt.event.*;
import java.util.Vector;
import java.awt.*;

public class GuestBilling implements ActionListener, MouseListener {
    public static String first; 
    public static String last;
    private JFrame frame = new JFrame(); // create a new frame
    private JButton backToMainMenu = new JButton("Cancel"); // button for cancel payment
    private JButton submit = new JButton("Submit"); // button for submitting billing information

    // strings for checking user inputs
    private String fName; 
    private String lName;
    private String emailaddress;
    private String cardNum;
    private String CVVnum;
    private String billInfo;
    private String expire;

    private JPanel panel = new JPanel();
    private JPanel buttonPanel = new JPanel(); // panel that holds all buttons
    private JPanel namePanel = new JPanel();  // panel that holds name label and textfield
    private JPanel emailPanel = new JPanel(); // panel that holds email label and textfield
    private JPanel infoPanel = new JPanel();  // panel for message
    private JPanel cardPanel = new JPanel(); // panel that holds card number label and textfield
    private JPanel billingPanel = new JPanel(); // panel that holds billing label and textfield

    private JTextField firstName = new JTextField("Ex: Yousef"); // textfield for user to insert first name
    private JTextField lastName = new JTextField("Ex: Akhtar"); // textfield for user to insert last name
    private JTextField email = new JTextField(); // textfield for user to insert email
    private JTextField cardNumber = new JTextField("Ex: 4510 1049 2945 3457"); // textfield for user to insert card number
    private JTextField CVV = new JTextField("Ex: 402"); // textfield for user to insert cvv number
    private JTextField billing = new JTextField(); // textfield for user to insert billing address
    private JTextField expiration = new JTextField("Ex: 02/23"); // textfield for user to insert expiration date

    private JLabel fNameLabel = new JLabel("First Name: "); // label for first name textfield
    private JLabel LNameLabel = new JLabel(" Last Name: "); // label for last name textfield
    private JLabel emailLabel = new JLabel("Email Address: "); // label for email textfield
    private JLabel infoLabel = new JLabel("Please enter your information below: "); 
    private JLabel cardNumberLabel = new JLabel("Card Number: "); // label for card number textfield
    private JLabel CVVLabel = new JLabel(" CVV: "); // label for cvv number textfield
    private JLabel billingAddress = new JLabel("Billing Address:"); // label for billing address textfield
    private JLabel expiry = new JLabel("Expiration:"); // label for expiry textfield
    private Vector<Integer> reserved; 

    GuestBilling(Vector<Integer> reserved) { // ctor
        frame.setBackground(Color.green); // set top of frame to green
        this.reserved = reserved;
        backToMainMenu.addActionListener(this); // This adds an action listener to the back to main menu button
        firstName.addMouseListener(this); // This adds a mouse listener to the first name text field
        lastName.addMouseListener(this); // This adds a mouse listener to the last name text field
        cardNumber.addMouseListener(this); // This adds a mouse listener to the card number text field
        expiration.addMouseListener(this); // This adds a mouse listener to the expiration text field
        CVV.addMouseListener(this); // This adds a mouse listener to the cvv number text field
        submit.addActionListener(this); // This adds an action listener to the submit button

        buttonPanel.setLayout(new FlowLayout()); // This sets the layout of the button panel to a flow layout
        namePanel.setLayout(new FlowLayout()); // This sets the layout of the name panel to a flow layout
        emailPanel.setLayout(new FlowLayout()); // This sets the layout of the email panel to a flow layout
        infoPanel.setLayout(new FlowLayout()); // This sets the layout of the message to a flow layout
        cardPanel.setLayout(new FlowLayout()); // This sets the layout of the card panel to a flow layout
        billingPanel.setLayout(new FlowLayout()); // This sets the layout of the billing address to a flow layout

        infoPanel.add(infoLabel); // This adds the first name label to the info panel
        namePanel.add(fNameLabel); // This adds the first name label to the name panel
        namePanel.add(firstName); // This adds the first name text field to the name panel
        namePanel.add(LNameLabel); // This adds the last name label to the name panel
        namePanel.add(lastName); // This adds the last name text field to the name panel

        emailPanel.add(emailLabel); // This adds the email label to the email panel
        emailPanel.add(email); // This adds the email text field to the email panel

        cardPanel.add(cardNumberLabel); // This adds card number label to card panel
        cardPanel.add(cardNumber); // This adds card number textfield to card panel
        cardPanel.add(CVVLabel); // This adds cvv number label to card panel
        cardPanel.add(CVV); // This adds cvv number textfield to card panel

        billingPanel.add(billingAddress); // This adds billing address label to billing panel
        billingPanel.add(billing); // This adds billing address textfield to billing panel
        billingPanel.add(expiry); // This adds expiry label to billing panel
        billingPanel.add(expiration); // This adds expiry textfield to billing panel

        buttonPanel.add(submit); // This adds the submit button to the button panel
        buttonPanel.add(backToMainMenu); // This adds the back to main menu button to the button panel
        firstName.setColumns(9); // This sets the number of columns in the first name text field to 9
        lastName.setColumns(9); // This sets the number of columns in the last name text field to 9
        email.setColumns(24); // This sets the number of columns in the email text field to 24
        cardNumber.setColumns(15); // This sets the number of columns in the card number text field to 15
        expiration.setColumns(6); // This sets the number of columns in the expiration text field to 6
        billing.setColumns(13); // This sets the number of columns in the billing address text field to 13
        CVV.setColumns(6); // This sets the number of columns in the cvv number text field to 6

        backToMainMenu.setFocusable(false); // This sets the focusable property of the back to main menu button to false

        frame.setTitle("Billing Information"); // This sets the title of the frame to "Create Account"

        namePanel.setBounds(70, 300, 360, 300);
        emailPanel.setBounds(78, 65, 440, 300); // This sets the bounds of the email panel
        cardPanel.setBounds(80, 105, 430, 300);
        billingPanel.setBounds(40, 145, 500, 300);

        panel.setLayout(new BorderLayout()); // This sets the layout of the panel to a border layout
        panel.add(billingPanel, BorderLayout.CENTER);
        panel.add(cardPanel, BorderLayout.CENTER);
        panel.add(emailPanel, BorderLayout.CENTER); // This adds the email panel to the center of the panel
        panel.add(namePanel, BorderLayout.CENTER); // This adds the name panel to the center of the panel
        panel.add(infoPanel, BorderLayout.PAGE_START);

        frame.add(panel, BorderLayout.CENTER); // This adds the panel to the center of the frame
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This sets the default close operation of the frame to
                                                              // exit on close
        frame.setSize(600, 250); // This sets the size of the frame to 600 by 250
        frame.setVisible(true); // This sets the visibility of the frame to true
        frame.setResizable(false); // This sets the resizable property of the frame to false
        frame.setLocationRelativeTo(null); // This sets the location of the frame to the center of the screen
    }

    public boolean checkInputs() { // This method checks if the inputs are valid
        fName = firstName.getText(); // This gets the text from the first name text field
        lName = lastName.getText(); // This gets the text from the last name text field
        emailaddress = email.getText(); // This gets the text from the email text field
        cardNum = cardNumber.getText(); // This gets the text from the email text field
        CVVnum = CVV.getText(); // This gets the text from the email text field
        billInfo = billing.getText(); // This gets the text from the email text field
        expire = expiration.getText(); // This gets the text from the email text field
        // This checks if the first name text field is empty
        if (fName.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, no first name entered.");
            return false;
        }
        // This checks if the last name text field is empty
        if (fName.contains(":") || fName.contains("/") || fName.contains(".")) {
            JOptionPane.showMessageDialog(null, "Error, first name cannot contain special characters.");
            return false;
        }
        // This checks if the last name text field is empty
        if (!Character.isUpperCase(fName.charAt(0)) || !Character.isUpperCase(lName.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Error, first letter in first/last name must be capital.");
            return false;
        }
        // This checks if the last name text field is empty
        if (lName.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, no last name entered.");
            return false;
        }
        // This checks if the last name text field is empty
        if (lName.contains(":") || lName.contains("/") || lName.contains(".")) {
            JOptionPane.showMessageDialog(null, "Error, last name cannot contain special characters.");
            return false;
        }
        // This checks if the email text field is empty
        if (emailaddress.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, no email address entered.");
            return false;
        }
        // This checks if the email text field is empty
        if (!emailaddress.contains("@") || !emailaddress.contains(".") || emailaddress.length() < 6) {
            JOptionPane.showMessageDialog(null, "Error, invalid email address entered.");
            return false;
        }
        // This checks if the email text field is empty
        if (cardNum.equals("") || cardNum.contains(":")) {
            JOptionPane.showMessageDialog(null,
                    cardNum + " is an invalid card number\nPlease enter a valid card number.");
            return false;
        }
        // This checks if the email text field is empty
        if (!(cardNum.length() >= 12)) {
            JOptionPane.showMessageDialog(null,
                    cardNum + " is not a long enough number.\nPlease enter a valid card number.");
            return false;
        }
        // This checks if the email text field is empty
        if (CVVnum.equals("") || CVVnum.length() != 3 || CVVnum.contains(":")) {
            JOptionPane.showMessageDialog(null, CVVnum + " is an invalid CVV. Please enter a 3 digit CVV number");
            return false;
        }
        // This checks if the email text field is empty
        if (billInfo.equals("") || billInfo.length() < 5) {
            JOptionPane.showMessageDialog(null, "Error, invalid billing address entered");
            return false;
        }
        // This checks if the email text field is empty
        if (expire.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, no expiry date entered.");
            return false;
        }
        // This checks if the email text field is empty
        if (!expire.contains("/") || !Character.isDigit(expire.charAt(0)) || !Character.isDigit(expire.charAt(1))
                || !Character.isDigit(expire.charAt(3)) || !Character.isDigit(expire.charAt(4))) {
            JOptionPane.showMessageDialog(null,
                    "Error, expiry date must be in the format 03/23\nwhere 03 is the month and 23 is the year.");
            return false;
        }

        Database db = new Database(); // This creates a new database object
        Guest guest = new Guest(fName, lName, emailaddress, cardNum, CVVnum, billInfo, expire); // This creates a new
                                                                                                // guest object
        if (!db.AddGuest(guest)) { // This checks if the guest was added to the database
            JOptionPane.showMessageDialog(null, "Unable to add billing information");
            return false; // This returns false
        }
        return true; // This returns true
    }

    @Override
    public void actionPerformed(ActionEvent e) { // This method is called when an action is performed
        if (e.getSource().equals(backToMainMenu)) { // This checks if the back to main menu button was pressed
            frame.dispose(); // This disposes of the frame
            new MainGUI(); // This creates a new instance of the MainGUI class
        } else if (e.getSource().equals(submit) && checkInputs()) { // This checks if the submit button was pressed and
                                                                    // the inputs are valid
            frame.dispose(); // This disposes of the frame
            first = firstName.getText(); // This gets the text from the first name text field
            last = lastName.getText(); // This gets the text from the last name text field
            new TicketSummary(reserved); // This creates a new instance of the TicketSummary class
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(firstName)) { // This checks if the first name text field was clicked
            firstName.setText("");
        }
        if (e.getSource().equals(lastName)) { // This checks if the last name text field was clicked
            lastName.setText("");
        }
        if (e.getSource().equals(cardNumber)) { // This checks if the card number text field was clicked
            cardNumber.setText("");
        }
        if (e.getSource().equals(CVV)) { // This checks if the CVV text field was clicked
            CVV.setText("");
        }
        if (e.getSource().equals(expiration)) { // This checks if the expiration text field was clicked
            expiration.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
