package reservation.system.main;
public class ReservationSystem 
{	
	public static void main(String[] args)
	{
		HotelSystem hs = new HotelSystem();
		
		@SuppressWarnings("unused")
		SystemDisplay mmd = new SystemDisplay(hs);
		
		hs.populateUsers();
	}
}