package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
    
public class MovieNews implements ActionListener {
    private JFrame frame = new JFrame(); // create frame

    private JPanel messagePanel = new JPanel(); // create panel that contains message
    private JPanel newsPanel = new JPanel(); // create news panel
    private JPanel bottomPanel = new JPanel(); // create panel for buttons

    // text inserted in movie news
    public String text = "Movie Title: Black Adam" + 
    "\n\nGenre: Action, Adventure" + 
    "\n\nNearly 5,000 years after he was bestowed with the powers of the gods-and imprisoned" + 
    "\njust as quickly-Black Adam is freed, ready to unleash his unique justice on the world." +
    "\n______________________________________________________________________________" + 
    "\n\nMovie Title: Halloween Ends" + 
    "\n\nGenre: Horror" +
    "\n\nFour years after her last encounter with masked killer Michael Myers, Laurie Strode is" +
    "\nliving with her granddaughter and trying to finish her memoir. Myers hasn't been seen," +
    "\nsince and Laurie finally decides to liberate herself from rage and fear and embrace life." + 
    "\nHowever, when a young man stands accused of murdering a boy that he was babysitting," +
    "\nit ignites a cascade of violence and terror that forces Laurie to confront the evil she" +
    "\ncan't control." +
    "\n______________________________________________________________________________" +
    "\n\nMovie Title: American Murderer" +
    "\n\nGenre: Thriller, Action" +
    "\n\nA charismatic con man plots his most elaborate scheme yet and, in the process, becomes" +
    "\nthe F.B.I.'s most unlikely - and elusive - top ten fugitive. (Based on a true story)" +
    "\n______________________________________________________________________________" +
    "\n\nMovie Title: Triangle of Sadness" +
    "\n\nGenre: Drama" + 
    "\n\nIn this wickedly funny Palme d'Or winner, social hierarchy is turned upside down," +
    "\nrevealing the tawdry relationship between power and beauty. Celebrity model couple," +
    "\nCarl and Yaya are invited on a luxury cruise for the uber-rich, helmed by an unhinged" +
    "\nboat captain. What first appeared instagrammable ends catastrophically, leaving the" +
    "\nsurvivors stranded on a desert island and fighting for survival." +
    "\n______________________________________________________________________________" +
    "\n\nMovie Title: Smile" +
    "\n\nGenre: Horror" +
    "\n\nAfter witnessing a bizarre, traumatic patient incident, Dr. Rose Cotter starts" +
    "\nexperiencing terrifying visions. As the lines between reality and nightmares blur," +
    "\nRose must confront her troubling past to escape her chilling new reality." +
    "\n\n";

    private JLabel message = new JLabel("Movies Coming Soon:"); // label at top of screen 
    private JButton back = new JButton("Back to Main Menu"); // button for returning to registered menu
    private JTextArea news = new JTextArea(34, 48); // set size of textarea that contains the text
    // a vertical scroll bar to access all the text content
    private JScrollPane scrollPane = new JScrollPane(news, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


    MovieNews() {
        frame.setBackground(Color.green); // set top of frame to green
        messagePanel.setLayout(new FlowLayout()); // set message panel layout to a flow layout 
        messagePanel.add(message); // add message label to message panel

        bottomPanel.setLayout(new FlowLayout()); // set bottom panel to a flow layout
        back.addActionListener(this); // This adds an action listener to the back to registered menu button
        bottomPanel.add(back); // insert back button to bottom panel

        news.append(text); // add the movie text to news panel
        news.setCaretPosition(0); // set scroll bar to top by default
        news.setEditable(false); // make the textarea non editable
        newsPanel.setLayout(new FlowLayout()); // set news panel to a flow layout
        newsPanel.add(scrollPane); // add scroll bar to news panel

        frame.setTitle("Movie News"); // set title of the frame 
        frame.add(messagePanel, BorderLayout.PAGE_START); // add message to top of frame
        frame.add(newsPanel, BorderLayout.WEST); // add news panel to center of frame (starting on left side)
        frame.add(bottomPanel, BorderLayout.PAGE_END); // add buttons to bottom of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit gui if user clicks close
        frame.setSize(600, 650); // set size of frame
        frame.setVisible(true); // set frame to visible for user
        frame.setResizable(false); // frame cannot be resized
        frame.setLocationRelativeTo(null); // set frame to center of user screen
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back)){ // if user presses back button
            frame.dispose(); // dispose of current frame
            new RegisteredMenu(); // reopen registered menu
        }
    }
}
    