package reservation.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ErrorWindow extends JDialog {

    ErrorWindow(JFrame mainFrame){
        super((Window)null);
        setModal(true);
        setLayout(null);

        JLabel msg = new JLabel("Invalid Username or Password.");
        JButton ok = new JButton("OK");
        msg.setBounds(50, 25, 200, 40);
        ok.setBounds(75, 75, 120, 40);

        add(msg);
        add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        setSize(300, 200);
        setLocationRelativeTo(mainFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    ErrorWindow(String message, JFrame mainFrame){
        super((Window)null);
        setModal(true);
        setLayout(null);

        JLabel msg = new JLabel(message);
        JButton ok = new JButton("OK");
        msg.setBounds(50, 25, 200, 40);
        ok.setBounds(75, 75, 120, 40);

        add(msg);
        add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        setSize(300, 200);
        setLocationRelativeTo(mainFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}