package GUI;

import javax.swing.*;

import Entities.*;

import java.awt.event.*;
import java.awt.*;

public class LoginMenu implements ActionListener {

    private JFrame frame = new JFrame(); // create new frame

    private JButton backToMainMenu = new JButton("Main Menu"); // button to return to main menu
    private JButton login = new JButton("Login"); // button to login

    private JTextField username = new JTextField(); // text field to enter username
    private JPasswordField password = new JPasswordField(); // text field to enter password

    private JPanel buttonPanel = new JPanel(); // panel to hold buttons at bottom of screen
    private JPanel userPanel = new JPanel(); // panel to hold username label and text field
    private JPanel passPanel = new JPanel(); // panel to hold password label and text field

    private JLabel userLabel = new JLabel("Username: "); // label for username text field
    private JLabel passLabel = new JLabel("Password: "); // label for password text field

    private String userInput; // string to hold user input for username
    private String passInput; // string to hold user input for password

    LoginMenu() { // constructor
        backToMainMenu.addActionListener(this); // this adds a actionlistener to main menu button
        login.addActionListener(this); // this adds a actionlistener to login button
        frame.setBackground(Color.green); // set top of frame to green
        buttonPanel.setLayout(new FlowLayout()); // set button panel to a flow layout
        buttonPanel.add(login); // add the login button to the button panel
        buttonPanel.add(backToMainMenu); // add the main menu button to the button panel

        userPanel.setLayout(new FlowLayout()); // set user panel to a flow layout
        userPanel.add(userLabel); // add user label to user panel
        userPanel.add(username); // add username text field to user panel

        passPanel.setLayout(new FlowLayout()); // set pass panel to a flow layout
        passPanel.add(passLabel); // add pass label to pass panel
        passPanel.add(password); // add password text field to pass panel

        username.setColumns(11); // set number of columns in username text field
        password.setColumns(11); // set number of columns in password text field

        frame.setTitle("Login"); // set title of frame to login
        frame.add(userPanel, BorderLayout.PAGE_START); // set the user panel to top of screen
        frame.add(passPanel, BorderLayout.CENTER); // set the pass panel to center of screen
        frame.add(buttonPanel, BorderLayout.PAGE_END); // set the button panel to bottom of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit if user closes frame
        frame.setSize(450, 160); // set size of frame
        frame.setVisible(true); // set frame visible to user
        frame.setLocationRelativeTo(null); // set frame to center of screen
    }

    boolean checkInputs() { // method to check if user input is valid
        userInput = username.getText(); // get user input for username
        passInput = String.valueOf(password.getPassword()); // get user input for password
        Database db = new Database(); // create new database object
        if (!db.FindAccount(userInput, passInput)) { // if user input is not valid
            JOptionPane.showMessageDialog(null, "Username or password is invalid. Please try again.");
            return false; // if user input is invalid, return false
        }
        return true; // if user input is valid, return true
    }

    @Override
    public void actionPerformed(ActionEvent e) { // method to handle button clicks
        if (e.getSource().equals(backToMainMenu)) { // if user clicks main menu button
            frame.dispose(); // close login menu
            new MainGUI(); // open main menu
        } else if (e.getSource().equals(login) && checkInputs()) { // if user clicks login button and user input is
                                                                   // valid
            frame.dispose(); // close login menu
            MainGUI.button = "logged"; // set button to logged
            MainGUI.user = username.getText(); // set user to username
            if (userInput.compareTo("admin") == 0) { // if user is admin
                new AdminGUI(); // open admin menu
            } else { // if user is not admin
                new RegisteredMenu(); // open registered menu
            }
        }
    }
}