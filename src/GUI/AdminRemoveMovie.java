package GUI;

import javax.swing.*;

import Entities.Database;

import java.awt.*;
import java.awt.event.*;

public class AdminRemoveMovie implements ActionListener {
    private JFrame frame = new JFrame();    // This is the frame that will hold all the panels
    private JPanel panel = new JPanel();    // This is the starting panel for a new GUI window
    private JPanel bottomPanel = new JPanel();  // This is the starting panel for a new GUI window
    private JPanel topPanel = new JPanel(); // This is the starting panel for a new GUI window
    private JLabel label = new JLabel("Insert Movie Name:");    //Label that helps declare window
    private JLabel note = new JLabel("Note: Do not remove featured movies");    //provides a warning for the GUI page
    private JTextField insertMovieName = new JTextField();  //Admin inserts a movie name that isnt featured
    private JButton confirm = new JButton("Confirm");   //button to confirm admins movie deletion choice
    private JButton back = new JButton("Back to Admin Menu");   //button to go back to the main menu
    
    AdminRemoveMovie(){
        frame.setBackground(Color.green);   // This sets the backround to green
        frame.setTitle("Remove Movie"); //Sets title of GUI
        confirm.addActionListener(this);    //Adding action listeners to see if admin is selecting an option
        back.addActionListener(this);   //Adding action listeners to see if admin is selecting an option
        insertMovieName.setColumns(13); //setting columns for the movie name
        panel.setLayout(new FlowLayout()); //setting panels for the GUI window 
        bottomPanel.setLayout(new FlowLayout());    //setting panels for the GUI window 
        topPanel.setLayout(new FlowLayout());   //setting panels for the GUI window 
        topPanel.add(note); //setting panels for the GUI window 
        bottomPanel.add(confirm); //setting panels for the GUI window 
        bottomPanel.add(back);  //setting panels for the GUI window 
        panel.add(label); //setting panels for the GUI window 
        panel.add(insertMovieName); //setting panels for the GUI window 
        frame.add(panel); //setting frame for the GUI window 
        frame.add(bottomPanel, BorderLayout.PAGE_END); //setting frame for the GUI window 
        frame.add(topPanel, BorderLayout.PAGE_START); //setting frame for the GUI window 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting frame for the GUI window 
        frame.setSize(550, 150); //setting frame for the GUI window 
        frame.setVisible(true); //setting frame for the GUI window 
        frame.setResizable(false); //setting frame for the GUI window 
        frame.setLocationRelativeTo(null); //setting frame for the GUI window 
    }

    public boolean InputCheck(){ //System checks if the removal of a new movie is valid
        String movieinput = insertMovieName.getText(); //converts the insertion of movie into string
        Database db = new Database(); //creates a new database
        if(!db.RemoveMovie(movieinput)){
            JOptionPane.showMessageDialog(null, "Unable to remove movie");
            return false; //returns a false boolean if it cannot remove the movie
        }
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e){//checks if action is sucesully added into the database
        if (e.getSource().equals(confirm) && InputCheck()){//confirms with the function input check listed above
            JOptionPane.showMessageDialog(null, "Movie removed successfully"); //system displays statement that movie is added succesfully
            frame.dispose();//dispose of old frame
            new AdminGUI();//display new gui frame
        }
        if (e.getSource().equals(back)){//if not successfull
            frame.dispose();//do not display message and go back to admin gui menu
            new AdminGUI();
        }
    }
}

