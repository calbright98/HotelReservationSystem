package reservation.system.main;

import java.util.Date;

public class Reservation {

    private Guest guest;
    private Room room;
    private Date StartDate;
    private Date EndDate;

    Reservation(Guest g, Room r,Date start, Date end)
    {
        guest = g;
        room = r;
        StartDate = start;
        EndDate = end;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

}