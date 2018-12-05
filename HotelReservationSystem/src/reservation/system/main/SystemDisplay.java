package reservation.system.main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import reservation.panels.UserSelectionPanel;

@SuppressWarnings("serial")
public class SystemDisplay extends JFrame
{	
	JPanel currentPanel;
	HotelSystem hs;
	
	public SystemDisplay(HotelSystem hs)
	{
		this.hs = hs;
		
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

    public boolean checkNewGuest(String name){
        return hs.checkGuest(name);
    }

    public void addGuest(Guest g){
        hs.addGuest(g);
    }
}