package GUI;

import javax.swing.*;

import Entities.Account;
import Entities.Database;
import Entities.RegisteredUserStrategy;

import java.awt.event.*;
import java.awt.*;

public class CreateAccount implements ActionListener, MouseListener {
    private Account registeredAccount;
    private JFrame frame = new JFrame();
    private JButton backToMainMenu = new JButton("Main Menu");
    private JButton submit = new JButton("Submit");

    private JPanel panel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel namePanel = new JPanel();
    private JPanel info = new JPanel();
    private JPanel emailPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JPanel cardPanel = new JPanel();
    private JPanel billingPanel = new JPanel();

    private JTextField firstName = new JTextField("Ex: Yousef");
    private JTextField lastName = new JTextField("Ex: Akhtar");
    private JTextField username = new JTextField();
    private JTextField password = new JTextField();
    private JTextField email = new JTextField();
    private JTextField cardNumber = new JTextField("Ex: 4510 1049 2945 3457");
    private JTextField CVV = new JTextField("Ex: 402");
    private JTextField billing = new JTextField();
    private JTextField expiration = new JTextField("Ex: 02/23");

    private JLabel fNameLabel = new JLabel("First Name: ");
    private JLabel LNameLabel = new JLabel(" Last Name: ");
    private JLabel userLabel = new JLabel("Username:  ");
    private JLabel passwordLabel = new JLabel("  Password: ");
    private JLabel emailLabel = new JLabel("Email Address: ");
    private JLabel infoLabel = new JLabel("Please enter your information below: ");
    private JLabel cardNumberLabel = new JLabel("Card Number: ");
    private JLabel CVVLabel = new JLabel(" CVV: ");
    private JLabel billingAddress = new JLabel("Billing Address:");
    private JLabel expiry = new JLabel("Expiration:");

    private String fName;
    private String lName;
    private String usernameString;
    private String passwordString;
    private String emailaddress;
    private String cardNum;
    private String CVVnum;
    private String billInfo;
    private String expire;

    CreateAccount() {
        frame.setBackground(Color.green);

        backToMainMenu.addActionListener(this); // This adds an action listener to the back to main menu button
        firstName.addMouseListener(this); // This adds a mouse listener to the first name text field
        lastName.addMouseListener(this); // T his adds a mouse listener to the last name text field
        username.addMouseListener(this); // This adds a mouse listener to the username text field
        cardNumber.addMouseListener(this);
        expiration.addMouseListener(this);
        CVV.addMouseListener(this);
        submit.addActionListener(this); // This adds an action listener to the submit button

        info.setLayout(new FlowLayout()); // This sets the layout of the info panel to a flow layout
        buttonPanel.setLayout(new FlowLayout()); // This sets the layout of the button panel to a flow layout
        namePanel.setLayout(new FlowLayout()); // This sets the layout of the name panel to a flow layout
        emailPanel.setLayout(new FlowLayout()); // This sets the layout of the email panel to a flow layout
        infoPanel.setLayout(new FlowLayout()); // This sets the layout of the message to a flow layout
        cardPanel.setLayout(new FlowLayout());
        billingPanel.setLayout(new FlowLayout());

        infoPanel.add(infoLabel); // This adds the first name label to the info panel
        namePanel.add(fNameLabel); // This adds the first name label to the name panel
        namePanel.add(firstName); // This adds the first name text field to the name panel
        namePanel.add(LNameLabel); // This adds the last name label to the name panel
        namePanel.add(lastName); // This adds the last name text field to the name panel

        emailPanel.add(emailLabel); // This adds the email label to the email panel
        emailPanel.add(email); // This adds the email text field to the email panel

        cardPanel.add(cardNumberLabel);
        cardPanel.add(cardNumber);
        cardPanel.add(CVVLabel);
        cardPanel.add(CVV);

        billingPanel.add(billingAddress);
        billingPanel.add(billing);
        billingPanel.add(expiry);
        billingPanel.add(expiration);

        info.add(userLabel); // This adds the username label to the info panel
        info.add(username); // This adds the username text field to the info panel
        info.add(passwordLabel); // This adds the password label to the info panel
        info.add(password); // This adds the password text field to the info panel

        buttonPanel.add(submit); // This adds the submit button to the button panel
        buttonPanel.add(backToMainMenu); // This adds the back to main menu button to the button panel
        username.setColumns(9); // This sets the number of columns in the username text field to 9
        password.setColumns(9); // This sets the number of columns in the password text field to 9
        firstName.setColumns(9); // This sets the number of columns in the first name text field to 9
        lastName.setColumns(9); // This sets the number of columns in the last name text field to 9
        email.setColumns(24); // This sets the number of columns in the email text field to 24
        cardNumber.setColumns(15);
        expiration.setColumns(6);
        billing.setColumns(13);
        CVV.setColumns(6);

        backToMainMenu.setFocusable(false); // This sets the focusable property of the back to main menu button to false

        frame.setTitle("Create Account"); // This sets the title of the frame to "Create Account"

        namePanel.setBounds(70, 300, 360, 300);
        info.setBounds(74, 60, 450, 300); // This sets the bounds of the info panel
        emailPanel.setBounds(78, 100, 440, 300); // This sets the bounds of the email panel
        cardPanel.setBounds(80, 145, 430, 300);
        billingPanel.setBounds(40, 190, 500, 300);

        panel.setLayout(new BorderLayout()); // This sets the layout of the panel to a border layout
        panel.add(billingPanel, BorderLayout.CENTER);
        panel.add(cardPanel, BorderLayout.CENTER);
        panel.add(emailPanel, BorderLayout.CENTER); // This adds the email panel to the center of the panel
        panel.add(info, BorderLayout.CENTER); // This adds the info panel to the center of the panel
        panel.add(namePanel, BorderLayout.CENTER); // This adds the name panel to the center of the panel
        panel.add(infoPanel, BorderLayout.PAGE_START);

        frame.add(panel, BorderLayout.CENTER); // This adds the panel to the center of the frame
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This sets the default close operation of the frame to
                                                              // exit on close
        frame.setSize(600, 350); // This sets the size of the frame to 600 by 250
        frame.setVisible(true); // This sets the visibility of the frame to true
        frame.setResizable(false); // This sets the resizable property of the frame to false
        frame.setLocationRelativeTo(null);
    }

    boolean checkInputs() {
        fName = firstName.getText(); // This gets the text from the first name text field and stores it in the fName
                                     // variable
        lName = lastName.getText(); // This gets the text from the last name text field and stores it in the lName
                                    // variable
        usernameString = username.getText(); // This gets the text from the username text field and stores it in the
                                             // usernameString variable
        passwordString = password.getText(); // This gets the text from the password text field and stores it in the
                                             // passwordString variable
        emailaddress = email.getText(); // This gets the text from the email text field and stores it in the
                                        // emailaddress
                                        // variable
        cardNum = cardNumber.getText(); // This gets the text from the card number text field and stores it in the
                                        // cardNum
                                        // variable
        CVVnum = CVV.getText(); // This gets the text from the CVV text field and stores it in the CVVnum
                                // variable
        billInfo = billing.getText(); // This gets the text from the billing text field and stores it in the billInfo
                                      // variable
        expire = expiration.getText(); // This gets the text from the expiration text field and stores it in the expire
                                       // variable
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
        // This checks if the username text field is empty
        if (usernameString.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, no username entered.");
            return false;
        }
        // This checks if the password text field is empty
        if (usernameString.length() < 5) {
            JOptionPane.showMessageDialog(null, "Error, username entered is too short. Enter a longer username.");
            return false;
        }
        // This checks if the password text field is empty
        if (passwordString.equals("") || passwordString.length() < 6) {
            JOptionPane.showMessageDialog(null, "Error, invalid password entered.");
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
        // This checks if the card number text field is empty
        if (cardNum.equals("") || cardNum.contains(":")) {
            JOptionPane.showMessageDialog(null,
                    cardNum + " is an invalid card number\nPlease enter a valid card number.");
            return false;
        }
        // This checks if the CVV text field is empty
        if (!(cardNum.length() >= 12)) {
            JOptionPane.showMessageDialog(null,
                    cardNum + " is not a long enough number.\nPlease enter a valid card number.");
            return false;
        }
        // This checks if the CVV text field is empty
        if (CVVnum.equals("") || CVVnum.length() != 3 || CVVnum.contains(":")) {
            JOptionPane.showMessageDialog(null, CVVnum + " is an invalid CVV. Please enter a 3 digit CVV number");
            return false;
        }
        // This checks if the billing text field is empty
        if (billInfo.equals("") || billInfo.length() < 5) {
            JOptionPane.showMessageDialog(null, "Error, invalid billing address entered");
            return false;
        }
        // This checks if the expiration text field is empty
        if (expire.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, no expiry date entered.");
            return false;
        }
        // This checks if the expiration text field is empty
        if (!expire.contains("/") || !Character.isDigit(expire.charAt(0)) || !Character.isDigit(expire.charAt(1))
                || !Character.isDigit(expire.charAt(3)) || !Character.isDigit(expire.charAt(4))) {
            JOptionPane.showMessageDialog(null,
                    "Error, expiry date must be in the format 03/23\nwhere 03 is the month and 23 is the year.");
            return false;
        }

        Database db = new Database(); // This creates a new Database object
        Account account = new Account(fName, lName, usernameString, passwordString, emailaddress, cardNum, CVVnum,
                billInfo, expire); // This creates a new Account object
        registeredAccount = new Account(fName, lName, usernameString, passwordString, emailaddress, cardNum,
                CVVnum,
                billInfo, expire, new RegisteredUserStrategy()); // This creates a new Account object with a
                                                                 // RegisteredUserStrategy
        if (!db.AddAccount(account)) { // This checks if the account was added to the database
            JOptionPane.showMessageDialog(null, "Unable to create account"); // This displays a message dialog
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) { // This is the action performed method
        if (e.getSource().equals(backToMainMenu)) { // This checks if the back to main menu button was pressed
            frame.dispose(); // This disposes of the frame
            new MainGUI(); // This creates a new instance of the MainGUI class
        } else if (e.getSource().equals(submit) && checkInputs()) { // This checks if the submit button was pressed and
                                                                    // if the checkInputs method returned true
            frame.dispose(); // This disposes of the frame
            MainGUI.button = "logged"; // This sets the button variable in the MainGUI class to logged

            JOptionPane.showMessageDialog(null, "Successfully created account. You will be charged $20 annually.");
            new LoginMenu(); // This creates a new instance of the LoginMenu class
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(firstName)) { // This checks if the first name text field was clicked
            firstName.setText(""); // This sets the text of the first name text field to nothing
        }
        if (e.getSource().equals(lastName)) { // This checks if the last name text field was clicked
            lastName.setText(""); // This sets the text of the last name text field to nothing
        }
        if (e.getSource().equals(cardNumber)) { // This checks if the card number text field was clicked
            cardNumber.setText(""); // This sets the text of the card number text field to nothing
        }
        if (e.getSource().equals(CVV)) { // This checks if the CVV text field was clicked
            CVV.setText(""); // This sets the text of the CVV text field to nothing
        }
        if (e.getSource().equals(expiration)) { // This checks if the expiration text field was clicked
            expiration.setText(""); // This sets the text of the expiration text field to nothing
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

    public Account getRegisteredAccount() {
        return registeredAccount;
    }
}
