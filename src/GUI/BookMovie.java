package GUI;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

import Entities.Database;
import Entities.Movie;

public class BookMovie implements ActionListener, MouseListener { // class
    public static Movie movie = Movie.getInstance(); // create new movie
    private JFrame frame = new JFrame(); // create new frame
    private JButton backToMainMenu = new JButton("Main Menu"); // create new button
    private JButton cont = new JButton("Continue"); // create new button
    private JPanel bottomPanel = new JPanel(); // create new panel
    private JPanel panel = new JPanel(); // create new panel
    private JComboBox<String> shows = new JComboBox<String>(); // create new combobox
    private JLabel showtimeLabel = new JLabel("Showtimes"); // create new label
    private Icon iconOne = new ImageIcon(getClass().getResource("/images/RushHour.jpg"));// for jar need image dir in
                                                                                         // src
    private Icon iconTwo = new ImageIcon(getClass().getResource("/images/LOTR.jpg")); // for jar need image dir in src
    private Icon iconThree = new ImageIcon(getClass().getResource("/images/Parasite.jpg")); // for jar need image dir in
                                                                                           // src
    private Icon iconFour = new ImageIcon(getClass().getResource("/images/Presteige.jpg")); // for jar need image dir in
                                                                                          // src
    private Icon iconFive = new ImageIcon(getClass().getResource("/images/Revanant.jpg")); // for jar need image dir in
                                                                                         // src
    private Icon iconSix = new ImageIcon(getClass().getResource("/images/se7en.jpg"));// get dir then this path
                                                                                      // must be in ensf480
                                                                                      // folder
    private JTextField search = new JTextField("Enter the movie you want to watch"); // create new textfield
    private JButton rushhourButton = new JButton(iconOne); // create new button
    private JButton lotrButton = new JButton(iconTwo); // create new button
    private JButton parasiteButton = new JButton(iconThree); // create new button
    private JButton presteigeButton = new JButton(iconFour); // create new button
    private JButton revanantButton = new JButton(iconFive); // create new button
    private JButton se7enButton = new JButton(iconSix); // create new button
    private JButton enterButton = new JButton("Enter"); // create new button
    private JLabel select = new JLabel("Select a Featured Movie or Search:"); // create new label
    private boolean found = false;  // boolean to check if movie is found
 
    BookMovie() {
        frame.setBackground(Color.green); // set top of frame to green
        backToMainMenu.addActionListener(this); // add action listener to button
        cont.addActionListener(this); // add action listener to button
        rushhourButton.addActionListener(this); // add action listener to button
        lotrButton.addActionListener(this);     // add action listener to button
        parasiteButton.addActionListener(this);
        presteigeButton.addActionListener(this);
        revanantButton.addActionListener(this);
        se7enButton.addActionListener(this);
        bottomPanel.setLayout(new FlowLayout()); // set layout of panel
        search.addMouseListener(this); // add mouse listener to textfield
        enterButton.addActionListener(this); // add action listener to button
        bottomPanel.add(showtimeLabel); // add label to panel
        bottomPanel.add(shows); // add combobox to panel
        bottomPanel.add(cont); // add button to panel 
        bottomPanel.add(backToMainMenu);    // add button to panel
        panel.setLayout(new BorderLayout()); // set layout of panel
        panel.add(bottomPanel, BorderLayout.PAGE_END); // add panel to frame
        rushhourButton.setBounds(40, 40, 180, 267); // set bounds of button
        lotrButton.setBounds(290, 40, 180, 267); // set bounds of button
        parasiteButton.setBounds(540, 40, 180, 267); // set bounds of button
        presteigeButton.setBounds(40, 360, 180, 267); // set bounds of button
        revanantButton.setBounds(290, 360, 180, 267); // set bounds of button
        se7enButton.setBounds(540, 360, 180, 267); // set bounds of button
        frame.add(rushhourButton); // add button to frame
        frame.add(lotrButton); // add button to frame
        frame.add(parasiteButton); // add button to frame
        frame.add(presteigeButton); // add button to frame
        frame.add(revanantButton); // add button to frame
        frame.add(se7enButton); // add button to frame
        enterButton.setBounds(600, 0, 75, 25); // set bounds of button
        frame.add(enterButton); // add button to frame
        // add label wherever
        select.setBounds(85, 0, 250, 25); // set bounds of label
        frame.add(select);// before panel
        search.setBounds(300, 0, 300, 25); // set bounds of textfield
        frame.add(search); // add textfield to frame
        frame.setTitle("Available Movies"); // set title of frame
        frame.add(panel); // add panel to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation
        frame.setSize(750, 750); // set size of frame
        frame.setVisible(true); // set frame to visible
        frame.setResizable(false);   // set frame to not resizable
        frame.setLocationRelativeTo(null); // set frame to center of screen

    }

    @Override
    public void actionPerformed(ActionEvent e) { // action performed method
        if (e.getSource().equals(backToMainMenu)) { // if back to main menu button is pressed
            frame.dispose(); // dispose of frame
            if (MainGUI.button.compareToIgnoreCase("guest") == 0) { // if guest button is pressed
                movie.setMoviename(null); // set movie name to null
                new MainGUI(); // create new main gui
            }
            if (MainGUI.button.compareToIgnoreCase("logged") == 0) { // if logged in button is pressed
                new RegisteredMenu(); // create new registered menu
            }
        }

        if (e.getSource().equals(cont)) { // if continue button is pressed
            try {
                movie.setScreentime((String) shows.getSelectedItem()); // set screen time to selected item in combobox
            } catch (Exception n) {
                JOptionPane.showMessageDialog(null, "Please select a Movie and Showtime"); // show error message
            }
            if (movie != null) {
                if (movie.getMoviename() == null) { // if movie name is null
                    JOptionPane.showMessageDialog(null, "Please select a Movie and Showtime"); // show error message
                } else if (movie.getScreentime() == null) { // if screen time is null
                    JOptionPane.showMessageDialog(null, "Please select a Showtime"); // show error message
                } else {
                    if (JOptionPane.showConfirmDialog(frame, movie.getMoviename(), "Confirm Movie Choice", 
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        new SeatSelection();
                        frame.dispose(); // dispose of frame
                    } else { // if no is pressed
                        movie.setMoviename(null); // set movie name to null
                        movie.setScreentime(null); // set screen time to null
                    }
                }

            }
        }
        if (e.getSource().equals(enterButton)) { // if enter button is pressed
            movie.setMoviename(search.getText()); // set movie name to text in textfield
            Database db = new Database(); // create new database
            if (db.FindMovie(search.getText()) == true) { // if movie is found
                JOptionPane.showMessageDialog(frame, "Movie Found"); // show message
                found = true; // set found to true
                movie.setMoviename(search.getText()); // set movie name to text in textfield
            } else { // if movie is not found
                JOptionPane.showMessageDialog(frame, "Movie not found"); // show message
                found = false; // set found to false
            }
        }
        if (e.getSource().equals(rushhourButton) || search.getText().compareToIgnoreCase("Rush Hour") == 0) { // if rush hour button is pressed or text in textfield is rush hour
            // new JOptionPane("Confirm Rush Hour?");
            shows.removeAllItems(); // remove all items from combobox
            shows.insertItemAt("9:30 2022-12-20", 0); // add items to combobox
            shows.insertItemAt("11:30 2022-12-22", 1);
            shows.insertItemAt("13:30 2022-12-23", 2);
            shows.insertItemAt("15:30 2022-12-26", 3);
            shows.insertItemAt("17:30 2022-12-29", 4);
            movie.setMoviename("Rush Hour");
            search.setText("Rush Hour");
        }
        if (e.getSource().equals(lotrButton) || search.getText().compareToIgnoreCase("Lord of the Rings") == 0) { // if lord of the rings button is pressed or text in textfield is lord of the rings
            shows.removeAllItems(); // remove all items from combobox
            shows.insertItemAt("9:45 2022-12-21", 0); // add items to combobox
            shows.insertItemAt("11:45 2022-12-23", 1);
            shows.insertItemAt("13:45 2022-12-24", 2);
            shows.insertItemAt("15:45 2022-12-25", 3);
            shows.insertItemAt("17:45 2022-12-27", 4);
            movie.setMoviename("Lord of the Rings");

            search.setText("Lord of the Rings");

        }
        if (e.getSource().equals(parasiteButton) || search.getText().compareToIgnoreCase("Parasite") == 0) { // if parasite button is pressed or text in textfield is parasite
            shows.removeAllItems(); // remove all items from combobox
            shows.insertItemAt("9:00 2022-12-20", 0); // add items to combobox
            shows.insertItemAt("11:00 2022-12-22", 1);
            shows.insertItemAt("13:00 2022-12-23", 2);
            shows.insertItemAt("15:00 2022-12-24", 3);
            shows.insertItemAt("17:00 2022-12-25", 4);
            movie.setMoviename("Parasite");
            search.setText("Parasite");
        }
        if (e.getSource().equals(presteigeButton) || search.getText().compareToIgnoreCase("The Prestige") == 0) { // if the prestige button is pressed or text in textfield is the prestige
            shows.removeAllItems(); // remove all items from combobox
            shows.insertItemAt("10:30 2022-12-19", 0); // add items to combobox
            shows.insertItemAt("12:30 2022-12-21", 1);
            shows.insertItemAt("14:30 2022-12-22", 2);
            shows.insertItemAt("16:30 2022-12-24", 3);
            shows.insertItemAt("18:30 2022-12-25", 4);
            movie.setMoviename("The Prestige");
            search.setText("The Prestige");
        }
        if (e.getSource().equals(revanantButton) || search.getText().compareToIgnoreCase("The Revenant") == 0) { // if the revenant button is pressed or text in textfield is the revenant
            shows.removeAllItems(); // remove all items from combobox
            shows.insertItemAt("10:45 2022-12-20", 0); // add items to combobox
            shows.insertItemAt("12:45 2022-12-22", 1);
            shows.insertItemAt("14:45 2022-12-23", 2);
            shows.insertItemAt("16:45 2022-12-25", 3);
            shows.insertItemAt("18:45 2022-12-27", 4);
            movie.setMoviename("The Revenant");
            search.setText("The Revenant");
        }
        if (e.getSource().equals(se7enButton) || search.getText().compareToIgnoreCase("Se7en") == 0) { // if se7en button is pressed or text in textfield is se7en
            shows.removeAllItems(); // remove all items from combobox
            shows.insertItemAt("10:00 2022-12-21", 0); // add items to combobox
            shows.insertItemAt("12:00 2022-12-23", 1);
            shows.insertItemAt("14:00 2022-12-25", 2);
            shows.insertItemAt("16:00 2022-12-27", 3);
            shows.insertItemAt("18:00 2022-12-29", 4);
            movie.setMoviename("Seven");
            search.setText("Seven");
        }
        if (found == true) { // if movie is found
            shows.removeAllItems(); // remove all items from combobox
            Database db = new Database(); // create new database
            movie.setMoviename(search.getText()); // set movie name to text in textfield
            movie.setShowtimes(db.GetShowtime(search.getText())); // set showtimes to showtimes from database
            for (int i = 0; i < movie.getShowtimes().size(); i++) { // for each showtime
                shows.insertItemAt(movie.getShowtimes().get(i), i); // add showtime to combobox
            } // end for
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) { // if mouse is clicked
        if (e.getSource().equals(search)) { // if textfield is clicked
            search.setText(""); // set text to blank
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

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