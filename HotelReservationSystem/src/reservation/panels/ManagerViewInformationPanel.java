package reservation.panels;
import javax.swing.*;

import reservation.system.main.SystemDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ManagerViewInformationPanel extends JPanel
{
    public ManagerViewInformationPanel()
    {
        setLayout(null);
        JButton viewbyday =new JButton("view by day" );
        JButton viewbyroom=new JButton("view by room");

        viewbyday.setBounds(100, 100, 200, 50);
        viewbyday.setBackground(Color.LIGHT_GRAY);
        viewbyroom.setBounds(100, 160, 200, 50);
        viewbyroom.setBackground(Color.LIGHT_GRAY);

        viewbyday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel(new ViewByDayPanel());
            }
        });

        viewbyroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel(new ViewByRoomPanel());
            }
        });

        this.add(viewbyday);
        this.add(viewbyroom);
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