package GUI;

import javax.swing.*;

import Entities.Database;

import java.awt.*;
import java.awt.event.*;

public class AdminAddMovie implements ActionListener, MouseListener {
    private JFrame frame = new JFrame(); // This is the starting frame for a new GUI window
    private JPanel panel = new JPanel(); // This is the starting panel for a new GUI window
    private JPanel midPanel = new JPanel(); // This is the starting mid panel for a new GUI window
    private JPanel bottomPanel = new JPanel(); // This is the starting bottom panel for a new GUI window
    private JLabel label = new JLabel("Insert Movie Name:"); // This is the label stating where to insert the movie name
    private JLabel label2 = new JLabel("Insert Showtime:   "); // This is the label stating where to insert the showtime
    private JTextField insertMovieName = new JTextField(); // This textfield helps insert the movie
    private JTextField insertShowTime = new JTextField("Ex: 13:00 2022-02-20"); // This textfield helps insert the showtime
    private JButton confirm = new JButton("Confirm"); // This is the button to confirm movie and showtime
    private JButton back = new JButton("Back to Admin Menu"); // This is the button to go back to the menu
    
    AdminAddMovie(){
        frame.setBackground(Color.green); // This sets the backround to green
        frame.setTitle("Add Movie"); //The title helps declare to add a movie
        insertShowTime.addMouseListener(this); //Adding mouse and action listeners to see if admin is inserting movies and showtimes
        confirm.addActionListener(this); //Adding mouse and action listeners to see if admin is inserting movies and showtimes
        back.addActionListener(this); //Adding mouse and action listeners to see if admin is inserting movies and showtimes
        insertMovieName.setColumns(12); //setting columns for both the movie and showtimes 
        insertShowTime.setColumns(12); //setting columns for both the movie and showtimes 
        panel.setLayout(new FlowLayout()); //Laying out panels to add movies and showtimes
        midPanel.setLayout(new FlowLayout()); //Laying out panels to add movies and showtimes
        bottomPanel.setLayout(new FlowLayout()); //Laying out panels to add movies and showtimes
        bottomPanel.add(confirm);  //Laying out panels to add movies and showtimes
        bottomPanel.add(confirm); //Laying out panels to add movies and showtimes
        bottomPanel.add(back); //Laying out panels to add movies and showtimes
        panel.add(label); //Laying out panels to add movies and showtimes
        midPanel.add(label2); //Laying out panels to add movies and showtimes
        midPanel.add(insertShowTime); //Laying out panels to add movies and showtimes
        panel.add(insertMovieName); //Laying out panels to add movies and showtimes
        frame.add(panel, BorderLayout.PAGE_START); //Frames that help declare the boarders and layout of the admin page
        frame.add(midPanel, BorderLayout.CENTER); //Frames that help declare the boarders and layout of the admin page
        frame.add(bottomPanel, BorderLayout.PAGE_END); //Frames that help declare the boarders and layout of the admin page
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frames that help declare the boarders and layout of the admin page
        frame.setSize(450, 150); //Sets the dimension for the frame
        frame.setVisible(true); //sets the GUI window as visible 
        frame.setResizable(false); //Cannot resize this window
        frame.setLocationRelativeTo(null); //the system does not set location relative
    }

    public boolean InputCheck(){ //System checks if the addition of a new movie is valid
        String movieinput = insertMovieName.getText(); //converts the insertion of movie into string
        String showtimeinput = insertShowTime.getText(); //converts the insertion of showtime into string
        Database db = new Database(); //creates a new database
        if(!db.AddMovie(movieinput,showtimeinput)){
            JOptionPane.showMessageDialog(null, "Unable to add movie");
            return false; //returns a false boolean if it cannot add the movie
        }
        return true; //else it returns true
    }
    @Override
    public void actionPerformed(ActionEvent e){ //checks if action is sucesully added into the database
        if (e.getSource().equals(confirm) && InputCheck()){ //confirms with the function input check listed above
            JOptionPane.showMessageDialog(null, "Movie added successfully"); //system displays statement that movie is added succesfully
            frame.dispose(); //dispose of old frame
            new AdminGUI(); //display new gui frame
        }
        if (e.getSource().equals(back)){ //if not successfull
            frame.dispose(); //do not display message and go back to admin gui menu
            new AdminGUI();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { //these functions help to recognize if mouse is being used
        if (e.getSource().equals(insertShowTime)) {
            insertShowTime.setText("");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) { //these functions help to recognize if mouse is being used
        if (e.getSource().equals(insertShowTime)) {
            insertShowTime.setText("");
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}

