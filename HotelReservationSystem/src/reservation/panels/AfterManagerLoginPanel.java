package reservation.panels;

import javax.swing.*;

import reservation.system.main.SystemDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterManagerLoginPanel extends JPanel {

    public AfterManagerLoginPanel() {
        setLayout(null);
        JButton view = new JButton("view information");
        JButton load = new JButton("load existing reservations");
        JButton save = new JButton("save reservations");
        JButton quit = new JButton("QUIT");

        view.setBounds(100, 50, 200, 30);
        view.setBackground(Color.LIGHT_GRAY);
        load.setBounds(100, 90, 200, 30);
        load.setBackground(Color.LIGHT_GRAY);
        save.setBounds(100, 130, 200, 30);
        save.setBackground(Color.LIGHT_GRAY);
        quit.setBounds(100, 250, 200, 30);
        quit.setBackground(Color.RED);
        quit.setForeground(Color.WHITE);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemDisplay sd = getTopFrame();
                sd.getHs().saveReservations();
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadReservations();
            }
        });
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel(new ManagerViewInfoPanel());
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemDisplay sd = getTopFrame();
                sd.getHs().saveReservations();
                sd.dispose();
            }
        });

        this.add(view);
        this.add(load);
        this.add(save);
        this.add(quit);
    }

    /**
     * Replaces itself with a new panel based on which button was clicked
     * @param p the panel that will replace this one.
     */
    public void changePanel(JPanel p){
        SystemDisplay topFrame = (SystemDisplay) SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(p);
    }

    public void loadReservations(){
        SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
        topFrame.loadReservations();
    }

    private SystemDisplay getTopFrame(){
        return (SystemDisplay) SwingUtilities.getWindowAncestor(this);
    }
}