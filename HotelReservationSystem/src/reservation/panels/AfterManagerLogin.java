package reservation.panels;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterManagerLogin extends JPanel
{
    public AfterManagerLogin()
    {
        JButton view =new JButton("view information" );
        JButton load=new JButton("load existing reservations");
        JButton save =new JButton("save reservations");
        //JButton quit =new JButton("quit the system");
        save.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        load.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        view.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        view.setPreferredSize(new Dimension(200, 200));
        load.setPreferredSize(new Dimension(200, 200));
        save.setPreferredSize(new Dimension(200, 200));
        this.add(view);
        this.add(load);
        this.add(save);
    }
}