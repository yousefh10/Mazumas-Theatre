package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AdminGUI implements ActionListener {
    private JFrame frame = new JFrame(); // This is the frame that will hold all the panels
    private JPanel panel = new JPanel(); // This is the starting panel for a new GUI window
    private JPanel topPanel = new JPanel(); // This is the starting panel for a new GUI window
    private JButton addMovie = new JButton("Add Movie"); //This is the button that will allow you to add movie
    private JButton removeMovie = new JButton("Remove Movie"); //This button removes a movie
    private JButton addUser = new JButton("Add User"); //This button adds user
    private JButton removeUser = new JButton("Remove User"); //This button removes user
    private JButton mainMenu = new JButton("Return to User Menu"); // This is the button that will take you back to the main menu
    private JLabel label = new JLabel("Select one of the options below:");

    public AdminGUI() {
        frame.setBackground (Color.green); // This sets the backround of the GUI window to green
        addMovie.addActionListener(this); //Adding action listeners to see if admin is selecting an option
        removeMovie.addActionListener(this); //Adding action listeners to see if admin is selecting an option
        addUser.addActionListener(this); //Adding action listeners to see if admin is selecting an option
        removeUser.addActionListener(this); //Adding action listeners to see if admin is selecting an option
        mainMenu.addActionListener(this); //Adding action listeners to see if admin is selecting an option
        frame.setTitle("Admin Menu"); //Window title
        panel.setLayout(new FlowLayout());
        topPanel.setLayout(new FlowLayout());
        panel.add(addMovie); //Laying out panels to show addmovie
        panel.add(removeMovie); //Laying out panels to show removeMovie
        panel.add(addUser); //Laying out panels to show addUser 
        panel.add(removeUser); //Laying out panels to show removeUser
        panel.add(mainMenu); //Laying out panels to show MainMenu
        topPanel.add(label); //Laying out panels 
        frame.add(topPanel, BorderLayout.PAGE_START); //Frames that help declare the boarders and layout of the admin page
        frame.add(panel, BorderLayout.PAGE_END); //Frames that help declare the boarders and layout of the admin page
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frames that help declare the boarders and layout of the admin page
        frame.setSize(750, 150); //Sets the dimension for the frame
        frame.setVisible(true); //sets the GUI window as visible
        frame.setResizable(false); //Cannot resize this window
        frame.setLocationRelativeTo(null); //the system does not set location relative
    }
 

    @Override
    public void actionPerformed(ActionEvent e) { //checks if the action performed on mainmenu based on the admins input
        if (e.getSource().equals(mainMenu)) {
            frame.dispose(); //disposes existing frame
            MainGUI.button = "admin"; //makes new button called admin 
            new MainGUI(); //creates a new mainGUI
        }
        if (e.getSource().equals(addMovie)) { //checks if the action performed on addMovie based on the admins input
            frame.dispose(); //disposes existing frame
            MainGUI.button = "admin"; //makes new button called admin 
            new AdminAddMovie(); //creates a new mainGUI
        }
        if (e.getSource().equals(removeMovie)) { //checks if the action performed on removeMovie based on the admins input
            frame.dispose(); //disposes existing frame
            MainGUI.button = "admin"; //makes new button called admin
            new AdminRemoveMovie(); //creates a new mainGUI
        }
        if (e.getSource().equals(removeUser)) { //checks if the action performed on removeUser based on the admins input
            frame.dispose(); //disposes existing frame
            MainGUI.button = "admin"; //makes new button called admin
            new AdminRemoveUser(); //create s a new mainGUI
        }
        if (e.getSource().equals(addUser)) { //checks if the action performed on addUser based on the admins input
            frame.dispose(); //disposes existing frame
            MainGUI.button = "admin"; //makes new button called admin
            new AdminAddUser(); //creates a new mainGUI
        }
    }
}
