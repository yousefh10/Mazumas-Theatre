package GUI;

import javax.swing.*;

import Entities.Database;

import java.awt.*;
import java.awt.event.*;

public class AdminRemoveUser implements ActionListener {
    private JFrame frame = new JFrame(); // This is the frame that will hold all the panels
    private JPanel panel = new JPanel(); // This is the starting panel for a new GUI window
    private JPanel bottomPanel = new JPanel(); // This is the starting panel for a new GUI window
    private JLabel label = new JLabel("Insert Username:");  // System label username  
    private JTextField insertMovieName = new JTextField();  // create a textfield for a movie name
    private JButton confirm = new JButton("Confirm"); // System creates a confirm button 
    private JButton back = new JButton("Back to Admin Menu"); // System has a back button that admin menu
    
    AdminRemoveUser(){
        frame.setBackground(Color.green); // This sets the backround to green
        frame.setTitle("Remove User"); //Sets title of GUI
        confirm.addActionListener(this); //Adding action listeners to see if admin is selecting to remove user
        back.addActionListener(this); //Adding action listeners to see if admin is selecting to remove user
        insertMovieName.setColumns(12); //setting columns for the movie name
        panel.setLayout(new FlowLayout());  //setting panels for the GUI window 
        bottomPanel.setLayout(new FlowLayout());    //setting panels for the GUI window 
        bottomPanel.add(confirm);  //setting panels for the GUI window 
        bottomPanel.add(back);  //setting panels for the GUI window 
        panel.add(label); //setting panels for the GUI window 
        panel.add(insertMovieName); //setting panels for the GUI window 
        frame.add(panel); //setting frame for the GUI window
        frame.add(bottomPanel, BorderLayout.PAGE_END); //setting frame for the GUI window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting frame for the GUI window
        frame.setSize(450, 150); //setting frame for the GUI window
        frame.setVisible(true); //setting frame for the GUI window
        frame.setResizable(false); //setting frame for the GUI window
        frame.setLocationRelativeTo(null); //setting frame for the GUI window
    }
    public boolean InputCheck(){ //System checks if the removal of a new InputCheck is valid
        String usernameinput = insertMovieName.getText(); 
        Database db = new Database();
        if(!db.RemoveAccount(usernameinput)){
            JOptionPane.showMessageDialog(null, "Unable to remove user");
            return false;
        }
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e){ //System checks if the removal of a new InputCheck is valid
        if (e.getSource().equals(confirm) && InputCheck()){ //confirms with the function input check listed above
            JOptionPane.showMessageDialog(null, "User was removed successfully");
            frame.dispose(); //dispose of old frame
            new AdminGUI(); //display new gui frame
        }
        if (e.getSource().equals(back)){
            frame.dispose(); //do not display message and go back to admin gui menu
            new AdminGUI();
        }
    }
}

