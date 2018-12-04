package reservation.panels;
import javax.swing.*;

import reservation.system.main.SystemDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ManagerSignInPanel extends JPanel {

	JLabel l1, l2, title, subText;
    JTextField uName;
    JButton signInBtn;
    JPasswordField uPass;
    
    ManagerSignInPanel() {
    	
        setLayout(null);

        //Initialize Components
        title = new JLabel("Employee Log In");
        subText = new JLabel("Please enter your username and password.");
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        uName = new JTextField();
        uPass = new JPasswordField();
        signInBtn = new JButton("Sign In");

        //Set Bounds and component visuals
        title.setBounds(100, 20, 300, 30);
        title.setForeground(Color.blue);
        title.setFont(new Font("Sans", Font.BOLD, 25));
        subText.setBounds(50, 70, 300, 30);
        l1.setBounds(50, 110, 100, 30);
        l2.setBounds(50, 150, 100, 30);
        uName.setBounds(150, 110, 200, 30);
        uPass.setBounds(150, 150, 200, 30);
        signInBtn.setBounds(150, 210, 100, 30);

        //Add the components to the panel
        add(title);
        add(subText);
        add(l1);
        add(uName);
        add(l2);
        add(uPass);
        add(signInBtn);
                        
        //Note: if username and password is taken/incorrect we could add another JLabel to output error text
        //      or we could just create another frame that acts as a popup to output the error

        //Create and attach Listeners
        //...
        signInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if login valid (look through list)
            	if(checkLogin(uName.getText(), String.valueOf(uPass.getPassword()))) {
            		changePanel(new AfterManagerLoginPanel());
            	}else {
            		//else add error message
            		System.out.println("Invalid user, please try again");
            	}
            }
        });
    }

    /**
     * Replaces itself with a new panel based on which button was clicked
     * @param p the panel that will replace this one.
     */
    public void changePanel(JPanel p){
        SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(p);
        System.out.println("Im in: " + topFrame.getName());
    }
    
    public boolean checkLogin(String username, String password)
    {
        SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
    	return topFrame.checkLogin(username, password);
    }
}