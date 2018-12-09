package reservation.panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import reservation.system.main.Receipt;
import reservation.system.main.SystemDisplay;
@SuppressWarnings("serial")
public class ReceiptsPanel extends JPanel
{
    SystemDisplay topFrame = (SystemDisplay)SwingUtilities.getWindowAncestor(this);
    Receipt receipt=new Receipt();
    public ReceiptsPanel()
    {
        setLayout(new FlowLayout());
        JButton simeple = new JButton("simple receipt");
        simeple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapToSimpleReceiptPanel();
            }
        });
        JButton comprehensive = new JButton("comprehensive receipt");
        comprehensive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapToComprehensiveReceiptPanel();
            }
        });
        add(simeple);
        add(comprehensive);
    }
    public void swapToSimpleReceiptPanel()
    {
        SystemDisplay topFrame = (SystemDisplay) SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(new ShowReciptPanel(receipt.SimpleReceiptFormat(topFrame.getHs().getReservations(),"id")));
    }
    public void swapToComprehensiveReceiptPanel()
    {
        SystemDisplay topFrame = (SystemDisplay) SwingUtilities.getWindowAncestor(this);
        topFrame.setCurrentPanel(new ShowReciptPanel(receipt.ComprehensiveReceiptFormat(topFrame.getHs().getReservations(),"id")));
    }
}