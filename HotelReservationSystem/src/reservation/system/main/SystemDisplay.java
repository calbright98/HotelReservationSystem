package reservation.system.main;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;

import reservation.panels.ReservationDialog;
import reservation.panels.UserSelectionPanel;

@SuppressWarnings("serial")
public class SystemDisplay extends JFrame
{	
	private JPanel currentPanel;
	private HotelSystem hs;
	private User currentUser;
	
	public SystemDisplay(HotelSystem hs)
	{
		this.hs = hs;
		currentUser = null;
		
		currentPanel = new UserSelectionPanel();
		add(currentPanel);
		
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setCurrentPanel(JPanel panel)
	{	
		remove(currentPanel);
		currentPanel = panel;
		add(currentPanel);
		revalidate();
	}
	
	public boolean checkLogin(String username, String password)
	{
		if(hs.checkGuest(username, password)){
			return true;
		}else if(hs.checkManager(username, password)){
			return true;
		}return false;
	}

    public boolean checkNewGuest(String name)
    {
        return hs.checkGuest(name);
    }

    public void addGuest(Guest g)
    {
        hs.addGuest(g);
    }
    
    public void loadReservations()
    {
    	hs.populateReservations();
    }

    public void PrintReservation(LocalDate d)
    {
        ReservationDialog dialog = new ReservationDialog(hs.getReservations(),d);
    }
    public void PrintReservation(int room)
    {
        ReservationDialog dialog = new ReservationDialog(hs.getReservations(),room);
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
}