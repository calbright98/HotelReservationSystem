package reservation.system.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Room implements Comparable{

    private final int number;
    private final double rate;
    private String type;
    private LocalDate checkin;
    private LocalDate checkout;

    Room(int num, double r, String t){
        number = num;
        rate = r;
        type = t;
    }

    public int getRoomNumber(){return number;}
    
    public double getRate(){return rate;}
    
    /**
     * @param checkinDate the date the user wishes to check-in
     * @return whether or not the room is available for the entered date
     */
    public boolean checkAvailability(LocalDate checkinDate, LocalDate checkoutDate){
    	if(checkin == null)					//If there are no reserved dates
    	{
    		checkin = checkinDate;
    		checkout = checkoutDate;
    		return true;
    	}
    	if(checkin.isEqual(checkinDate)) {	//If checkin equals checkinDate
    		return false;
    	}else if(checkin.isBefore(checkinDate) && checkout.isAfter(checkinDate)) {	//If requested date is in-between reserved date
    		return false;
    	}else if(checkin.isBefore(checkinDate) && checkout.isBefore(checkoutDate) && checkout.isAfter(checkinDate)) {	//If request date overlaps reserved date
    		return false;
    	}else if(checkin.isAfter(checkinDate) && checkout.isAfter(checkoutDate) && checkin.isBefore(checkoutDate)) {	//If request date overlaps reserved date
    		return false;
    	}return true;
    }
    public String getType(){return type;}

    
    public String toString()
    {
    	return "Room number: " + number;
    }
    
    public int compareTo(Room r) 
    {
        return getRoomNumber() - r.getRoomNumber();
    }
}