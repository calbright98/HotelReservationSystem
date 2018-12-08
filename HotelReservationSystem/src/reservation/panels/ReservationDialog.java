package reservation.panels;

import javax.swing.*;
import reservation.system.main.Reservation;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class ReservationDialog extends JDialog
{
    JTextArea textArea;
    JTextArea reservations;
    public ReservationDialog(ArrayList<Reservation> list, LocalDate d)
    {
        textArea=new JTextArea("These are the reservations in the date "+d+":");
        this.setLayout(new BorderLayout());
        this.add(textArea,BorderLayout.NORTH);
        reservations=new JTextArea();
        for (Reservation R:list)
        {
            //between
            if (R.getStartDate().isBefore(d) && R.getEndDate().isAfter(d)||R.getStartDate().isEqual(d))
            {
                String S="Guest: "+R.getGuest().getFirstName()+","+R.getGuest().getLastName()+"  room: " +R.getRoom().getRoomNumber()+"   Date: "+R.getStartDate()+"  to  "+R.getEndDate();
                reservations.append(S);
            }
        }
        this.setLocationRelativeTo(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(reservations,BorderLayout.CENTER);
    }
    public ReservationDialog(ArrayList<Reservation> list, int room)
    {
        textArea=new JTextArea("These are the reservations of the room "+room+":");
        this.setLayout(new BorderLayout());
        this.add(textArea,BorderLayout.NORTH);
        reservations=new JTextArea();
        for (Reservation R:list)
        {
            //between
            if (R.getRoom().getRoomNumber()==room)
            {
                String S="Guest: "+R.getGuest().getFirstName()+","+R.getGuest().getLastName()+"  room: " +R.getRoom().getRoomNumber()+"   Date: "+R.getStartDate()+"  to  "+R.getEndDate();
                reservations.append(S);
            }
        }
        this.setLocationRelativeTo(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(reservations,BorderLayout.CENTER);
    }
}