package reservation.system.main;
public class ReservationSystem 
{	
	public static void main(String[] args)
	{
		HotelSystem hs = new HotelSystem();
		SystemDisplay mmd = new SystemDisplay();
		
		hs.populateUsers();
	}
}