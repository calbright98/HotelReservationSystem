package reservation.panels;

import javax.swing.*;

import reservation.system.main.Reservation;
import reservation.system.main.SystemDisplay;
import reservation.system.main.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class GuestDeletePanel extends JPanel
{

    public GuestDeletePanel(ArrayList<Reservation> R,User G)
    {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        int size=R.size();

        for (int i=0; i<size;i++)
        {
            if (R.get(i).getGuest().getID()==G.getID())
            {
                long daysBetween = ChronoUnit.DAYS.between(R.get(i).getStartDate(), R.get(i).getEndDate());
                double total = R.get(i).getRoom().getRate()*(daysBetween);
                JPanel panel=new JPanel();
                JTextArea textArea=new JTextArea();
                String re=R.get(i).getRoom().getType()+"  $"+R.get(i).getRoom().getRate()+"/day\n"+"period: "+R.get(i).getStartDate()+" - "+R.get(i).getEndDate()+"\n total $: "+total+"\n\n\n";
                textArea.setText(re);
                JButton cancel=new JButton("cancel");
                panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
                int finalI = i;
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            delete(finalI);
                    }
                });
                panel.add(textArea);
                panel.add(cancel);
                this.add(panel);
            }
        }

    }
    public void delete(int i)
    {
        SystemDisplay topFrame = (SystemDisplay) SwingUtilities.getWindowAncestor(this);
        topFrame.getHs().getReservations().remove(i);
        topFrame.setCurrentPanel(new GuestDeletePanel(topFrame.getHs().getReservations(),topFrame.getCurrentUser()));
    }

}