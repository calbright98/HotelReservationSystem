package reservation.panels;
import javax.swing.*;
import java.awt.*;

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
        signInBtn = new JButton("Sign In!");

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
    }
}