package reservation.panels;
import javax.swing.*;

public class ShowReciptPanel extends JPanel
{
    JTextArea textArea;
    ShowReciptPanel(String receipt)
    {
        textArea=new JTextArea();
        textArea.setText(receipt);
        this.add(textArea);
    }
}