package reservation.system.main;

import java.util.ArrayList;
import java.util.Date;

public abstract class Room {

    private final int number;
    private final double rate;
    private String type;
    private ArrayList<Date> reservedDays;

    Room(int num, double r, String t){
        number = num;
        rate = r;
        type = t;
        reservedDays = new ArrayList<Date>();
    }

    public int getRoomNumber(){return number;}
    public double getRate(){return rate;}
    public boolean checkAvailability(Date d){
        if(reservedDays.contains(d)){
            return false;
        }
        else{ return true;}
    }
    public String getType(){return type;}
    public void addReservedDate(Date d){reservedDays.add(d);}
    public void addReservedDate(ArrayList<Date> days){reservedDays.addAll(days);}
}