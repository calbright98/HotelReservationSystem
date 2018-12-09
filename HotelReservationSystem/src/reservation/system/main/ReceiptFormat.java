package reservation.system.main;

import java.time.temporal.ChronoUnit;

public class ReceiptFormat implements ReceiptFormater
{
    private int total;
    @Override
    public String information(Reservation R) {
        total=0;
        long daysBetween = ChronoUnit.DAYS.between(R.getStartDate(), R.getEndDate());
        total += R.getRoom().getRate()*(daysBetween);
        return R.getRoom().getType() +" $"+R.getRoom().getRate()+"/day"+"\n"+"period: "+R.getStartDate()+"  -   "+R.getEndDate();
    }
    @Override
    public String totalmoney() {
        return "\n"+"The total amount for this reservation is : "+Integer.toString(total)+"\n\n\n";
    }
    public int getTotal()
    {return total;}
}