package reservation.panels;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class ManagerViewInformation extends JPanel
{
    public ManagerViewInformation()
    {
        this.setLayout(new GridLayout(1, 2));
        JButton viewbyday =new JButton("view by day" );
        JButton loadbyroom=new JButton("view by room");
        this.add(viewbyday);
        this.add(loadbyroom);
    }
}