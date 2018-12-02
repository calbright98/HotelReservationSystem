package reservation.panels;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import reservation.system.main.SystemDisplay;

@SuppressWarnings("serial")
/**
 * 
 * @author Chris
 */
public class UserSelectionPanel extends JPanel
{
	public UserSelectionPanel()
	{
		setLayout(new FlowLayout());
				
		JButton GuestButton = new JButton("Guest");
		GuestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				swaptToGuestPanel();
			}
		});
		
		JButton ManagerButton = new JButton("Manager");
		ManagerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				swapToManagerPanel();
			}
		});
		
		add(GuestButton);
		add(ManagerButton);
	}
	
	public void swaptToGuestPanel()
	{
		SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
		topFrame.setCurrentPanel(new GuestSelectionPanel());
	}
	
	public void swapToManagerPanel()
	{
		SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
		topFrame.setCurrentPanel(new ManagerSignInPanel());
	}
}
