package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CancellationConfirmed implements ActionListener {
    private JFrame frame = new JFrame(); // create new frame
    private JButton mainMenu = new JButton("Return to Main Menu"); // button to return to main menu
    private JButton exitButton = new JButton("Exit Program"); // button to exit program
    private JPanel bottomPanel = new JPanel(); // panel to hold buttons at bottom of screen
    private JPanel mainPanel = new JPanel(); // panel to hold message label
    private JLabel message = new JLabel("Your cancellation was successful."); // message displayed to user confirming
                                                                              // cancellation

    CancellationConfirmed() {
        frame.setBackground(Color.green); // set top of frame to green
        mainMenu.addActionListener(this); // this adds a actionlistener to main menu button
        exitButton.addActionListener(this); // this adds a actionlistener to exit program button

        bottomPanel.setLayout(new FlowLayout()); // set bottom panel to a flow layout
        bottomPanel.add(mainMenu); // add the main menu button to the bottom panel
        bottomPanel.add(exitButton); // add the exit button to the bottom panel

        mainPanel.setLayout(new FlowLayout()); // set main panel to a flow layout
        mainPanel.add(message); // add message to main panel

        frame.setTitle("Cancellation Confirmation"); // set title of frame to cancellation confirmed
        frame.add(mainPanel, BorderLayout.CENTER); // set the main panel to center of screen
        frame.add(bottomPanel, BorderLayout.PAGE_END); // set the bottom panel to bottom of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit if user closes frame
        frame.setSize(440, 200); // set size of frame
        frame.setVisible(true); // set frame visible to user
        frame.setResizable(false); // set frame so user cannot resize it
        frame.setLocationRelativeTo(null); // set frame to center of screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mainMenu)) { // if user clicks main menu button
            frame.dispose(); // dispose of current frame
            if (MainGUI.button.compareTo("logged") == 0) { // if user came from registered menu
                new RegisteredMenu(); // open registered menu
            } else if (MainGUI.button.compareTo("guest") == 0) { // if user came from main menu
                new MainGUI(); // open main menu
            }
        } else if (e.getSource().equals(exitButton)) { // if user clicks exit button
            System.exit(0); // exit program
        }
    }
}
