package reservation.system.main;
import javax.swing.JFrame;
import javax.swing.JPanel;
import reservation.panels.UserSelectionPanel;

@SuppressWarnings("serial")
/**
 * 
 * @author Chris
 */
public class SystemDisplay extends JFrame
{	
	JPanel currentPanel;
	
	public SystemDisplay()
	{
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
}