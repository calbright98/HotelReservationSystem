package reservation.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reservation.system.main.SystemDisplay;

@SuppressWarnings("serial")
public class AfterManagerLogin extends JPanel {

    public AfterManagerLogin() {
        setLayout(null);
        JButton view = new JButton("view information");
        JButton load = new JButton("load existing reservations");
        JButton save = new JButton("save reservations");

        view.setBounds(100, 50, 200, 30);
        view.setBackground(Color.LIGHT_GRAY);
        load.setBounds(100, 90, 200, 30);
        load.setBackground(Color.LIGHT_GRAY);
        save.setBounds(100, 130, 200, 30);
        save.setBackground(Color.LIGHT_GRAY);


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save reservations to file
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //****Leave Blank for now until she tells us
            }
        });
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel(new ManagerViewInformationPanel());
            }
        });


        this.add(view);
        this.add(load);
        this.add(save);
    }

    /**
     * Replaces itself with a new panel based on which button was clicked
     * @param p the panel that will replace this one.
     */
    public void changePanel(JPanel p){
        SystemDisplay topFrame = (SystemDisplay) SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(p);
        System.out.println("Im in: " + topFrame.getName());
    }
}