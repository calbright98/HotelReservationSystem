package reservation.panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

@SuppressWarnings("serial")
/**
 * 
 * @author Chang Chanip
 */
public class ViewByDay extends JPanel
   {
       JPanel top;
       JPanel center;
       LocalDate D;
       JTextArea textArea;
       JButton nextMonth;
       JButton previousMonth;
       LocalDate P;								//previous month
       LocalDate end;							// the end of month(date)
       int endday;								// the end of month(day)
       LocalDate Pend;							// the end of next month(date)
       int Pendday;								// the end of next month(day)
       int first;								// the first day of week in number.
       
       public ViewByDay()
       {
    	   top = new JPanel();
    	   center = new JPanel();
    	   D = LocalDate.now();
    	   
    	   constructPanel();
           displayMonth();
           
           this.add(top, BorderLayout.NORTH);
           this.add(center, BorderLayout.CENTER);
       }
       
       public void displayMonth()
       {
    	   int j = 0;
           for (;j<first%7;j++)
           {
               String label=Integer.toString(Pendday-first+1);
               JTextArea area = new JTextArea("\n   "+label);
               area.setEditable(false);
               center.add(area);
               Pendday++;
           }
           
           for (int i=1;i<endday+1;i++)
           {
               String label = Integer.toString(i);
               JButton keyButton = new JButton(label);
               center.add(keyButton);
           }
           
           for (int k=0;k<42-endday-j;k++)
           {
               String label = Integer.toString(k+1);
               JTextArea area = new JTextArea("\n   "+label);
               area.setEditable(false);
               center.add(area);
           }
       }
       
       public void constructPanel()
       {
    	   top = new JPanel();
    	   center = new JPanel();
    	   nextMonth = new JButton(">");
    	   nextMonth.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   D = D.plusMonths(1);
                   removeAll();
                   constructPanel();
                   displayMonth();
                   revalidate();
               }
           });
    	   
    	   previousMonth = new JButton("<");
    	   previousMonth.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   D = D.minusMonths(1);
                   removeAll();
                   constructPanel();
                   displayMonth();
                   revalidate();
               }
           });
    	   
    	   P = D.minusMonths(1);
    	   
           String Month = D.getMonth().toString();
           textArea = new JTextArea(Month);
           textArea.setEditable(false);
           
           top.setBackground(Color.white);
           center.setBackground(Color.white);
           
           first = D.getDayOfWeek().getValue();
           end = D.withDayOfMonth(D.lengthOfMonth());
           endday = end.getDayOfMonth();
           Pend = P.withDayOfMonth(P.lengthOfMonth());
           Pendday = Pend.getDayOfMonth();
           
           setLayout(new BorderLayout());
           
           top.add(textArea);
           top.add(previousMonth);
           top.add(nextMonth);

           center.setLayout(new GridLayout(7, 7));
           center.add(new JTextArea("\n    S"));
           center.add(new JTextArea("\n    M"));
           center.add(new JTextArea("\n    T"));
           center.add(new JTextArea("\n    W"));
           center.add(new JTextArea("\n    T"));
           center.add(new JTextArea("\n    F"));
           center.add(new JTextArea("\n    S"));
           
           this.add(top, BorderLayout.NORTH);
           this.add(center, BorderLayout.CENTER);
       }
   }