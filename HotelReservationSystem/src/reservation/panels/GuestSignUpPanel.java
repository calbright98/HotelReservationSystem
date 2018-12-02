package reservation.panels;
import javax.swing.*;
import java.awt.*;

public class GuestSignUpPanel extends JPanel{

    JLabel l1, l2, title;
    JTextField uName;
    JButton signUpBtn;
    JPasswordField uPass;

    GuestSignUpPanel() {

        setLayout(null);

        //Initialize Components
        title = new JLabel("Please enter desired username and password.");
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        uName = new JTextField();
        uPass = new JPasswordField();
        signUpBtn = new JButton("Sign Up");

        //Set Bounds and component visuals
        title.setBounds(50, 50, 300, 30);
        l1.setBounds(50, 110, 100, 30);
        l2.setBounds(50, 150, 100, 30);
        uName.setBounds(150, 110, 200, 30);
        uPass.setBounds(150, 150, 200, 30);
        signUpBtn.setBounds(150, 210, 100, 30);
        signUpBtn.setBackground(new Color(0,200,0));

        //Add the components to the panel
        add(title);
        add(l1);
        add(uName);
        add(l2);
        add(uPass);
        add(signUpBtn);

        //Note: if username and password is taken/incorrect we could add another JLabel to output error text
        //      or we could just create another frame that acts as a popup to output the error

        //Create and attach Listeners
            //...
    }
}
