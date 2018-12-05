package reservation.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import reservation.system.main.SystemDisplay;

@SuppressWarnings("serial")
public class AfterGuestLoginPanel extends JPanel
{
    public AfterGuestLoginPanel() {
        setLayout(null);
        JButton make = new JButton("Make a reservation");
        JButton viewcancel = new JButton("View/Cancel reservation");

        make.setBounds(100, 50, 200, 30);
        make.setBackground(Color.LIGHT_GRAY);
        viewcancel.setBounds(100, 90, 200, 30);
        viewcancel.setBackground(Color.LIGHT_GRAY);

        make.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MakeReservationWindow mrw = new MakeReservationWindow();
            }
        });
        viewcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
        });

        this.add(make);
        this.add(viewcancel);
    }

    /**
     * Replaces itself with a new panel based on which button was clicked
     * @param p the panel that will replace this one.
     */
    public void changePanel(JPanel p){
        SystemDisplay topFrame = (SystemDisplay) SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(p);
    }
    
    public void loadReservations()
    {
        SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
        topFrame.loadReservations();
    }
}