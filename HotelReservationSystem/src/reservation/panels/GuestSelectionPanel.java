package reservation.panels;
import javax.swing.*;

import reservation.system.main.SystemDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestSelectionPanel extends JPanel {

    JButton up, in;
    JLabel title, subText;

     GuestSelectionPanel() {

         setLayout(null);

         //Initialize Components
         title = new JLabel("WELCOME!");
         subText = new JLabel("Please sign up or log in");
         up = new JButton("Sign Up");
         in = new JButton("Log In");

         //Set Bounds and component visuals
         title.setBounds(125, 30, 150, 30);
         title.setForeground(Color.blue);
         title.setFont(new Font("Sans", Font.BOLD, 25));
         subText.setBounds(90, 80, 220, 30);
         up.setBounds(100, 160, 200, 30);
         up.setBackground(new Color(0,200,0));
         in.setBounds(100, 220, 200, 30);
         in.setBackground(Color.LIGHT_GRAY);

         //Add the components to the panel
         title.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
         add(title);
         subText.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
         add(subText);
         add(up);
         add(in);

        //Create and attach Listeners
         up.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 changePanel(new GuestSignUpPanel());
             }
         });

         in.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 changePanel(new GuestSignInPanel());
             }
         });

     }

    /**
     * Replaces itself with a new panel based on which button was clicked
     * @param p the panel that will replace this one.
     */
    public void changePanel(JPanel p){
        SystemDisplay topFrame = (SystemDisplay) SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(p);
    }
}
