package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame implements ActionListener {
    public static String user;
    public static String button;
    private JFrame frame = new JFrame(); // This is the frame that will hold all the panels
    private JButton exitProg = new JButton("Exit Program"); // This is the button that will exit the program
    private JButton login = new JButton("Login"); // This is the button that will login the user
    private JButton continueGuest = new JButton("Continue as Guest"); // This is the button that will book a movie
    private JPanel panel = new JPanel(); // This is the panel that will hold the buttons
    private JPanel bottom = new JPanel(); // This is the panel that will hold the bottom buttons
    private JButton createAccount = new JButton("Create Account"); // This is the button that will create a new account
    private JButton cancelBooking = new JButton("Cancel Booking");
    private JButton main = new JButton(new ImageIcon(getClass().getResource("/images/maing.png")));

    public MainGUI() {
        setupGUI();
    }

    public void setupGUI() {
        frame.setTitle("Movie Theater Ticket Reservation Program"); // This sets the title of the frame
        frame.setBackground(Color.green);
        createAccount.addActionListener(this); // This adds an action listener to the create account button
        cancelBooking.addActionListener(this);
        login.addActionListener(this); // This adds an action listener to the login button
        continueGuest.addActionListener(this); // This adds an action listener to the book movie button
        exitProg.addActionListener(this); // This adds an action listener to the exit program button

        bottom.add(createAccount); // This adds the create account button to the bottom panel
        bottom.add(continueGuest); // This adds the book movie button to the bottom panel
        bottom.add(login); // This adds the login button to the bottom panel
        bottom.add(cancelBooking);
        bottom.add(exitProg); // This adds the exit program button to the bottom panel
        main.setBorderPainted(false);

        panel.setLayout(new BorderLayout()); // This sets the layout of the panel to a border layout
        main.setBounds(100, 200, 500, 500);
        frame.add(main, BorderLayout.PAGE_START);
        panel.add(bottom, BorderLayout.PAGE_END); // This adds the bottom panel to the center of the panel
        frame.add(panel); // This adds the panel to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This sets the default close operation to exit on close
        frame.setSize(870, 730); // This sets the size of the frame
        frame.setVisible(true); // This sets the frame to be visible
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(createAccount)) { // This checks if the create account button was pressed
            frame.dispose(); // dispose of the current frame
            button = "account";
            new CreateAccount(); // create a new frame
        }
        if (e.getSource().equals(exitProg)) { // This checks if the exit program button was pressed
            if (JOptionPane.showConfirmDialog(this, // This shows a confirm dialog box
                    "Are you sure you want to exit?", "Confirm exit",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        if (e.getSource().equals(login)) { // This checks if the login button was pressed
            frame.dispose(); // dispose of the current frame
            button = "logged";
            new LoginMenu(); // create a new frame
        }
        if (e.getSource().equals(continueGuest)) { // This checks if the book movie button was pressed
            frame.dispose(); // dispose of the current frame
            button = "guest";

            new BookMovie(); // create a new frame
        }
        if (e.getSource().equals(cancelBooking)) {
            frame.dispose();
            MainGUI.button = "guest";
            new CancelBooking();
        }
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
