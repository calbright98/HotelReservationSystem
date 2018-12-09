package reservation.system.main;

import javax.swing.*;

import reservation.panels.DateReservationsView;
import reservation.panels.RoomReservationsView;
import reservation.panels.UserSelectionPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SystemDisplay extends JFrame
{
    private JPanel currentPanel;
    private JPanel previousPanel;
    private HotelSystem hs;
    private User currentUser;
    private boolean loggedIn;

    public SystemDisplay(HotelSystem hs)
    {
        currentPanel = new UserSelectionPanel();
        add(currentPanel);
        this.hs = hs;
        loggedIn = false;

        setVisible(true);
        setTitle("The Group3 Hotel");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setCurrentPanel(JPanel panel)
    {
        remove(currentPanel);
        previousPanel = currentPanel;
        currentPanel = panel;
        if(loggedIn) {
            add(currentPanel, BorderLayout.CENTER);
        }
        else add(currentPanel);
        revalidate();
        repaint();
    }

    public void setUserButtons(){
        loggedIn = true;
        setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        JButton back = new JButton("<-");
        JButton signOut = new JButton("Sign Out");

        //Create and attach Listeners
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setCurrentPanel(previousPanel);
            }
        });

        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedIn = false;
                remove(buttons);
                setCurrentPanel(new UserSelectionPanel());
            }
        });

        buttons.add(back);
        buttons.add(signOut);
        add(buttons, BorderLayout.NORTH);
    }

    public boolean checkLogin(String username, String password)
    {
        if(hs.checkGuest(username, password)){
            return true;
        }else if(hs.checkManager(username, password)){
            return true;
        }return false;
    }

    public boolean checkNewGuest(String name){
        return hs.checkGuest(name);
    }

    public void addGuest(Guest g){
        hs.addGuest(g);
    }

    public void loadReservations(){
        hs.populateReservations();
    }

    public void PrintReservation(LocalDate d, DateReservationsView view)
    {
        view.printDayInfo(hs.getReservations(), hs.getRooms(), d);
    }
    public void PrintReservation(int room, RoomReservationsView view)
    {
        view.printReservations(hs.getReservations(), room);
    }

    public void cancelReservation(int num){
        hs.getReservations().remove(num);
    }

    public ArrayList<Reservation> getReservations(){
        return hs.getReservations();
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurentUser(User newUser)
    {
        currentUser = newUser;
    }

    public User getUser(String username)
    {
        return hs.getUser(username);
    }

    public Room getAvailableRoom(boolean luxury, LocalDate ci, LocalDate co)
    {
        return hs.getAvailableRoom(luxury, ci, co);
    }

    public void addReservation(Reservation r)
    {
        hs.addReservation(r);
    }

    public void saveReservations(){
        hs.saveReservations();
    }
    
    public HotelSystem getHs()
    {
    	return hs;
    }
}