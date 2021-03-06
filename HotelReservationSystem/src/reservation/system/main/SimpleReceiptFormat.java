package reservation.system.main;

import java.time.temporal.ChronoUnit;

/**
 * it is concrete strategy to have the function to format one reservation into simple receipt
 * @author Chong, Chanip @version 1.0 12/8/2018
 */
public class SimpleReceiptFormat implements ReceiptFormater
{

    private int total;
    @Override
    /**
     * to make a reservation into a String and sum up the price
     * @param R one reservation in the system
     * @return one string that holds name, room, price, period
     */
    public String information(Reservation R) {
        total=0;
        long daysBetween = ChronoUnit.DAYS.between(R.getStartDate(), R.getEndDate());
        total += R.getRoom().getRate()*(daysBetween);
        return R.getRoom().getType() +" $"+R.getRoom().getRate()+"/day"+"\n"+"period: "+R.getStartDate()+"  -   "+R.getEndDate();
    }
    @Override
    /**
     *  to return price for one reservation and as a String
     * @return a total amount for one reservation in String
     */
    public String totalmoney() {
        return "\n"+"The total amount for this reservation is : "+Integer.toString(total)+"\n\n\n";
    }
    public int getTotal()
    {return total;}
}