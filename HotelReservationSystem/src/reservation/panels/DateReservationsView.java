package reservation.panels;

import javax.swing.*;

import reservation.system.main.Reservation;
import reservation.system.main.Room;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DateReservationsView extends JFrame{

        JTextArea textArea;
        JTextArea reservations;

    public DateReservationsView() {
        textArea = new JTextArea("ROOM INFORMATION FOR ");
        reservations = new JTextArea();

        setLayout(new BorderLayout());
        add(textArea, BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setSize(500, 500);
        setVisible(true);
        add(reservations, BorderLayout.CENTER);
    }

     public void printDayInfo (ArrayList<Reservation> list, ArrayList<Room> rooms, LocalDate theDate) {
        textArea.setText("ROOM INFORMATION FOR " + theDate + ":");
        reservations.setText("");

        String bookedRooms = "";
        String openRooms = "";

        reservations.append("\nAvailable Rooms:\n");

        for (Reservation R : list) {
            //between
            if (R.getStartDate().isBefore(theDate) && R.getEndDate().isAfter(theDate) || R.getStartDate().isEqual(theDate) || R.getEndDate().isEqual(theDate)) {
                bookedRooms += ("Room: " + R.getRoom().getRoomNumber() + " | Guest: " + R.getGuest().getFirstName() + "," + R.getGuest().getLastName() + "\n");
            }
        }

        for (Room R : rooms) {
            if (R.checkAvailability(theDate)) {
                openRooms += "Room: " + R.getRoomNumber() + "\n";
            }
        }

        reservations.append(openRooms);
        reservations.append("\nReserved Rooms:\n\n" + bookedRooms);
    }
}