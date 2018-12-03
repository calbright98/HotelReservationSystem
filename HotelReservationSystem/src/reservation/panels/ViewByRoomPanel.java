package reservation.panels;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ViewByRoomPanel extends JPanel
{
    JPanel top=new JPanel();
    JPanel center=new JPanel();
    JPanel centerR=new JPanel();
    JPanel botR=new JPanel();
    JPanel bot=new JPanel();
    JTextArea textfield=new JTextArea("Room View");
    public ViewByRoomPanel()
    {
        setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());         
        top.add(textfield);
        textfield.setEditable(false);
        textfield.setOpaque(false);
        center.setLayout(new BorderLayout());
        bot.setLayout(new BorderLayout());
        
        JTextArea economicRoom=new JTextArea("Economic Rooms:");
        economicRoom.setEditable(false);
        economicRoom.setOpaque(false);
        center.add(economicRoom,BorderLayout.NORTH);
        
        JTextArea luxuryRoom=new JTextArea("Luxory Rooms:");
        luxuryRoom.setEditable(false);
        luxuryRoom.setOpaque(false);
        bot.add(luxuryRoom,BorderLayout.NORTH);
        
        centerR.setLayout(new GridLayout(2, 5));
        botR.setLayout(new GridLayout(2, 5));
        botR.setPreferredSize(new Dimension(100, 200));
        centerR.setPreferredSize(new Dimension(100, 200));
        
        for (int i = 0; i < 10; i++)
        {
            int label=100+i;
            String room=Integer.toString(label);
            JButton keyButton = new JButton(room);
            keyButton.setPreferredSize(new Dimension(40, 40));
            centerR.add(keyButton);
        }
        
        for (int i = 0; i < 10; i++)
        {
            int label=200+i;
            String room=Integer.toString(label);
            JButton keyButton = new JButton(room);
            keyButton.setPreferredSize(new Dimension(40, 40));
            botR.add(keyButton);
        }
        
        center.add(centerR,BorderLayout.CENTER);
        bot.add(botR,BorderLayout.CENTER);
        this.add(top, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(bot, BorderLayout.SOUTH);
    }
}