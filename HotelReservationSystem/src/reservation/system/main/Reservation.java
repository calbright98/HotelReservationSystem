package reservation.system.main;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {

    private Guest guest;
    private Room room;
    private LocalDate StartDate;
    private LocalDate EndDate;

    public Reservation(Guest g, Room r, LocalDate start, LocalDate end)
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

    public LocalDate getStartDate() {
        return StartDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

}