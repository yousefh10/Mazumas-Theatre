package GUI;

import javax.swing.*;

import Entities.Account;
import Entities.Database;

import java.awt.event.*;
import java.awt.*;

public class AdminAddUser implements ActionListener, MouseListener {
    private JFrame frame = new JFrame(); 
    private JButton backToMainMenu = new JButton("Back"); // button for going back to admin menu
    private JButton submit = new JButton("Confirm"); // button to confirm addition of user to database

    private JPanel panel = new JPanel();
    private JPanel buttonPanel = new JPanel(); // panel for all buttons (back and confirm)
    private JPanel namePanel = new JPanel(); // panel for "First Name" and "Last Name" labels and textfields
    private JPanel info = new JPanel(); // 
    private JPanel emailPanel = new JPanel(); // panel for holding email textfield and label
    private JPanel infoPanel = new JPanel(); // panel for holding username and passwords labels and textfields
    private JPanel cardPanel = new JPanel(); // panel for holding card informations labels and textfields
    private JPanel billingPanel = new JPanel(); // panel for holding billing addresses labels and textfields

    private JTextField firstName = new JTextField("Ex: Yousef"); // textfield to insert first name
    private JTextField lastName = new JTextField("Ex: Akhtar"); // textfield to insert last name
    private JTextField username = new JTextField(); // textfield to insert username
    private JTextField password = new JTextField(); // textfield to insert password
    private JTextField email = new JTextField(); // textfield to insert email
    private JTextField cardNumber = new JTextField("Ex: 4510 1049 2945 3457"); // textfield to insert card number
    private JTextField CVV = new JTextField("Ex: 402"); // textfield to insert card CVV number
    private JTextField billing = new JTextField(); // textfield to insert billing address
    private JTextField expiration = new JTextField("Ex: 02/23"); // textfield to insert card expiry number

    private JLabel fNameLabel = new JLabel("First Name: "); // first name label to indicate to user what each textfield is for
    private JLabel LNameLabel = new JLabel(" Last Name: "); // last name label to indicate to user what each textfield is for
    private JLabel userLabel = new JLabel("Username:  "); // username label to indicate to user what each textfield is for
    private JLabel passwordLabel = new JLabel("  Password: "); // password label to indicate to user what each textfield is for
    private JLabel emailLabel = new JLabel("Email Address: "); // email label to indicate to user what each textfield is for
    private JLabel infoLabel = new JLabel("Please enter your information below: "); // label that tells the user to insert their info
    private JLabel cardNumberLabel = new JLabel("Card Number: "); // card number label to indicate to user what each textfield is for
    private JLabel CVVLabel = new JLabel(" CVV: "); // CVV label to indicate to user what each textfield is for
    private JLabel billingAddress = new JLabel("Billing Address:"); // billing label to indicate to user what each textfield is for
    private JLabel expiry = new JLabel("Expiration:"); // expiry label to indicate to user what each textfield is for

    // following strings made for error checking the inputs of the user 
    private String fName; 
    private String lName;
    private String usernameString;
    private String passwordString;
    private String emailaddress;
    private String cardNum;
    private String CVVnum;
    private String billInfo;
    private String expire;

    AdminAddUser() {
        frame.setBackground(Color.green); // set top of frame to green

        backToMainMenu.addActionListener(this); // This adds an action listener to the back to main menu button
        firstName.addMouseListener(this); // This adds a mouse listener to the first name text field
        lastName.addMouseListener(this); // This adds a mouse listener to the last name text field
        username.addMouseListener(this); // This adds a mouse listener to the username text field
        cardNumber.addMouseListener(this); // This adds a mouse listener to the card number text field
        expiration.addMouseListener(this); // This adds a mouse listener to the expiration text field
        CVV.addMouseListener(this); // This adds an action listener to the CVV field
        submit.addActionListener(this); // This adds an action listener to the submit button

        info.setLayout(new FlowLayout()); // This sets the layout of the info panel to a flow layout
        buttonPanel.setLayout(new FlowLayout()); // This sets the layout of the button panel to a flow layout
        namePanel.setLayout(new FlowLayout()); // This sets the layout of the name panel to a flow layout
        emailPanel.setLayout(new FlowLayout()); // This sets the layout of the email panel to a flow layout
        infoPanel.setLayout(new FlowLayout()); // This sets the layout of the message to a flow layout
        cardPanel.setLayout(new FlowLayout()); // This sets the layout of the card panel to a flow layout
        billingPanel.setLayout(new FlowLayout()); // This sets the layout of the billing panel to a flow layout

        infoPanel.add(infoLabel); // This adds the first name label to the info panel
        namePanel.add(fNameLabel); // This adds the first name label to the name panel
        namePanel.add(firstName); // This adds the first name text field to the name panel
        namePanel.add(LNameLabel); // This adds the last name label to the name panel
        namePanel.add(lastName); // This adds the last name text field to the name panel

        emailPanel.add(emailLabel); // This adds the email label to the email panel
        emailPanel.add(email); // This adds the email text field to the email panel

        cardPanel.add(cardNumberLabel); // This adds the card number label to the card panel
        cardPanel.add(cardNumber); //  This adds the card number textfield to the card panel
        cardPanel.add(CVVLabel);  // This adds the CVV number label to the card panel
        cardPanel.add(CVV); //  This adds the CVV number textfield to the card panel

        billingPanel.add(billingAddress); // This adds the billing address label to the billing panel
        billingPanel.add(billing); // This adds the billing address textfield to the billing panel
        billingPanel.add(expiry); // This adds the expiry label to the billing panel
        billingPanel.add(expiration); // // This adds the expiry textfield to the billing panel

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
        cardNumber.setColumns(15); // This sets the number of columns in the card number textfield to 15
        expiration.setColumns(6); // This sets the number of columns in the expiry number textfield to 6
        billing.setColumns(13); // This sets the number of columns in the billing address textfield to 13
        CVV.setColumns(6); // This sets the number of columns in the cvv number textfield to 6

        backToMainMenu.setFocusable(false); // This sets the focusable property of the back to main menu button to false

        frame.setTitle("Add User"); // set title of frame
        namePanel.setBounds(70, 300, 360, 300); // This sets the bounds of the name panel
        info.setBounds(74, 60, 450, 300); // This sets the bounds of the info panel
        emailPanel.setBounds(78, 100, 440, 300); // This sets the bounds of the email panel
        cardPanel.setBounds(80, 145, 430, 300); // This sets the bounds of the card panel
        billingPanel.setBounds(40, 190, 500, 300); // This sets the bounds of the billing panel

        panel.setLayout(new BorderLayout()); // This sets the layout of the panel to a border layout
        panel.add(billingPanel, BorderLayout.CENTER); // Add billing panel to center of panel
        panel.add(cardPanel, BorderLayout.CENTER); // Add card panel to center of panel
        panel.add(emailPanel, BorderLayout.CENTER); // This adds the email panel to the center of the panel
        panel.add(info, BorderLayout.CENTER); // This adds the info panel to the center of the panel
        panel.add(namePanel, BorderLayout.CENTER); // This adds the name panel to the center of the panel
        panel.add(infoPanel, BorderLayout.PAGE_START);

        frame.add(panel, BorderLayout.CENTER); // This adds the panel to the center of the frame
        frame.add(buttonPanel, BorderLayout.PAGE_END); // adds the button panel to bottom of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This sets the default close operation of the frame to
                                                              // exit on close
        frame.setSize(600, 350); // This sets the size of the frame to 600 by 250
        frame.setVisible(true); // This sets the visibility of the frame to true
        frame.setResizable(false); // This sets the resizable property of the frame to false
        frame.setLocationRelativeTo(null); // This sets the frame to center of screen
    }

    boolean checkInputs(){
        // Collect the text inserted in the textfields by the user
        fName = firstName.getText();
        lName = lastName.getText();
        usernameString = username.getText();
        passwordString = password.getText();
        emailaddress = email.getText();
        cardNum = cardNumber.getText();
        CVVnum = CVV.getText();
        billInfo = billing.getText();
        expire = expiration.getText();

        if (fName.equals("") || fName.contains(":")) { // Check for if user inserted invalid first name
            JOptionPane.showMessageDialog(null, "Error, no first name entered");
            return false;
        }
        if (lName.equals("") || lName.contains(":")) { // Check for if user inserted invalid last name
            JOptionPane.showMessageDialog(null, "Error, no last name entered");
            return false;
        }
        if (usernameString.equals("")) { // Check for if user did not insert username
            JOptionPane.showMessageDialog(null, "Error, no username entered");
            return false;
        }
        if (passwordString.equals("") || passwordString.length() < 6) { // Check for if user inserted invalid password
            JOptionPane.showMessageDialog(null, "Error, invalid password entered");
            return false;
        }
        if (emailaddress.equals("") || !emailaddress.contains("@")) { // Check for if user inserted invalid email
            JOptionPane.showMessageDialog(null, "Error, invalid email address entered");
            return false;
        }
        if (cardNum.equals("") || cardNum.contains(":")) { // Check for if user inserted incorrect card number
            JOptionPane.showMessageDialog(null, cardNum + " is an invalid card number\nPlease enter a valid card number");
            return false;
        }
        if (CVVnum.equals("") || CVVnum.length() != 3 || CVVnum.contains(":")) { // Check for if user inserted incorrect cvv number
            JOptionPane.showMessageDialog(null, CVVnum + " is an invalid CVV. Please enter a 3 digit CVV number");
            return false;
        }
        if (billInfo.equals("")) { // Check for if user inserted incorrect billing address
            JOptionPane.showMessageDialog(null, "Error, invalid billing address entered");
            return false;
        }
        if (expire.equals("") || !expire.contains("/")) { // Check for if user inserted incorrect expiry date
            JOptionPane.showMessageDialog(null, "Error, invalid expiry date entered");
            return false;
        }
        Database db = new Database(); // create a new database
        Account account = new Account(fName, lName, usernameString, passwordString,emailaddress, cardNum, CVVnum, billInfo, expire);
        db.AddAccount(account); // add account to database
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backToMainMenu)) { // if user clicks back button
            frame.dispose(); // This disposes of the frame
            new AdminGUI(); 
        }else if (e.getSource().equals(submit) && checkInputs()) {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "User added successfully");
            new AdminGUI();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { // If an example is in textfield, when user clicks on the textfield, it will clear example
        if (e.getSource().equals(firstName)) {
            firstName.setText("");
        }
        if (e.getSource().equals(lastName)) {
            lastName.setText("");
        }
        if (e.getSource().equals(cardNumber)) {
            cardNumber.setText("");
        }
        if (e.getSource().equals(CVV)) {
            CVV.setText("");
        }
        if (e.getSource().equals(expiration)) {
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
