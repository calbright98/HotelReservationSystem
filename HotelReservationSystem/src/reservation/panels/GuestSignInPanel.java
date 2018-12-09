package reservation.panels;

import javax.swing.*;

import reservation.system.main.SystemDisplay;
import reservation.system.main.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GuestSignInPanel extends JPanel {

    JLabel l1, l2, title, subText;
    JTextField uName;
    JButton signInBtn;
    JPasswordField uPass;

    GuestSignInPanel() {

        setLayout(null);

        //Initialize Components
        title = new JLabel("Welcome Back");
        subText = new JLabel("Please enter your username and password.");
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        uName = new JTextField();
        uPass = new JPasswordField();
        signInBtn = new JButton("Sign In");

        //Set Bounds and component visuals
        title.setBounds(100, 20, 200, 30);
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

        signInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if login valid (look through list)
                if(checkLogin(uName.getText(), String.valueOf(uPass.getPassword()))) {
                    changeToLoggedInWindow();
                }else {
                    //else add error message
                    MessageWindow mw = new MessageWindow("Invalid username or password");
                }
            }
        });
    }

    public void changePanel(JPanel p){
        SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(p);
    }

    public void changeToLoggedInWindow(){
        SystemDisplay topFrame = getTopFrame();
        topFrame.setUserButtons();
        changePanel(new AfterGuestLoginPanel());
    }

    public boolean checkLogin(String username, String password)
    {
        SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
        if(topFrame.checkLogin(username, password))
        {
            User user = topFrame.getUser(uName.getText());
            topFrame.setCurentUser(user);
            return true;
        }
        return false;
    }

    private SystemDisplay getTopFrame(){
        return (SystemDisplay) SwingUtilities.getWindowAncestor(this);
    }
}