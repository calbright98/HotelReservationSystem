package reservation.panels;
import javax.swing.*;

import reservation.system.main.Reservation;

import java.awt.*;
import java.util.ArrayList;

public class RoomReservationsView extends JFrame
{
    JTextArea textArea;
    JTextArea reservations;

    public RoomReservationsView()
    {
        textArea=new JTextArea("These are the reservations for Room ");
        this.setLayout(new BorderLayout());
        this.add(textArea,BorderLayout.NORTH);
        reservations=new JTextArea();

        this.setLocationRelativeTo(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(reservations,BorderLayout.CENTER);
    }

    public void printReservations(ArrayList<Reservation> list, int room){
        textArea.setText("These are the reservations of the room "+room+":");
        reservations.setText("");
        for (Reservation R:list)
        {
            //between
            if (R.getRoom().getRoomNumber() == room)
            {
                String S="Guest: "+R.getGuest().getFirstName()+","+R.getGuest().getLastName()+"  room: " +R.getRoom().getRoomNumber()+"   Date: "+R.getStartDate()+"  to  "+R.getEndDate();
                reservations.append(S);
            }
        }
    }
}