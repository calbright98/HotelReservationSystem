package reservation.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MessageWindow extends JDialog {
	
    public MessageWindow(String message){
        super((Window)null);
        setModal(true);
        setLayout(null);

        JTextArea msg = new JTextArea(message);
        msg.setLineWrap(true);
        msg.setEditable(false);
        msg.setOpaque(false);
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
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}