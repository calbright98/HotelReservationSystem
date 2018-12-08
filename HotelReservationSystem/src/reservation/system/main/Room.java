package reservation.system.main;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Room implements Comparable<Room> {

    private final int number;
    private final double rate;
    private String type;
    private ArrayList<LocalDate> reservedDays;

    Room(int num, double r, String t){
        number = num;
        rate = r;
        type = t;
        reservedDays = new ArrayList<LocalDate>();
    }

    public int getRoomNumber(){return number;}

    public double getRate(){return rate;}

    public boolean checkAvailability(LocalDate ci, LocalDate co){
        if(reservedDays.contains(ci) || reservedDays.contains(co)){
            return false;
        }
        else{
        	return true;
        }
    }
    
    public boolean checkAvailability(LocalDate d){
        if(reservedDays.contains(d)){
            return false;
        }
        else{
        	return true;
        }
    }
    
    public String getType(){return type;}

    public void addReservedDate(LocalDate d){reservedDays.add(d);}

    public void addReservedDate(ArrayList<LocalDate> days){reservedDays.addAll(days);}

    public int compareTo(Room r) {
        return getRoomNumber() - r.getRoomNumber();
    }
}