package reservation.panels;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MakeReservationWindow extends JDialog
{
	private LocalDate chosenMonth;
	private JComboBox<Integer> inDay;
	private JComboBox<String> inMonth;
	private JComboBox<Integer> inYear;
	
    public MakeReservationWindow(){
        super((Window)null);
        setModal(true);
        setLayout(new FlowLayout());
        
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("CANCEL");
        ok.setBounds(75, 75, 120, 40);
        
        //**********Check-in menus**********
        //----------Months-----------
        
        String[] months = new String[12];				//12 months to choose from
        for(int i = 1; i <= months.length; i++) {
        	months[i-1] = LocalDate.of(1, i, 1).getMonth().toString();
        }
        
        chosenMonth = LocalDate.now();
        inMonth = new JComboBox<String>(months);
        inMonth.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setMonth(inMonth.getSelectedIndex()+1);
			}
        });
        
        //----------Days-----------
        inDay = new JComboBox<Integer>();
        for(int i = 0; i < chosenMonth.lengthOfMonth(); i++) {	//Adds the correct amount of days according to the current chosen month
        	inDay.addItem(i+1);
        }
        
        //----------Years-----------
        Integer[] years = new Integer[5];						//Allows user to choose 5 years from this year
        for(int i = 0; i < years.length; i++) {
        	years[i] = i+LocalDate.now().getYear();
        }
        inYear = new JComboBox<Integer>(years);

        
        //**********Check-out menus**********
        //TODO: Need to be added

        add(ok);
        add(cancel);
        add(inDay);
        add(inMonth);
        add(inYear);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public void setMonth(int month)
    {
    	inDay.removeAllItems();
        chosenMonth = LocalDate.of(inYear.getItemAt(inYear.getSelectedIndex()), month, 1);
        for(int i = 0; i < chosenMonth.lengthOfMonth(); i++) {
        	inDay.addItem(i+1);
        }
    }
}