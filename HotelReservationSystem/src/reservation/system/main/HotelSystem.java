package reservation.system.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class HotelSystem {
    LuxuryRoom luxuryRooms[]= new LuxuryRoom[10];
    EconomicRoom economicRooms[]= new EconomicRoom[10];
    ArrayList<Manager> managers;
    ArrayList<Guest> guests;
    ArrayList<Reservation> reservations;
    //either an action listener or changeListner needed to attach the main display frame to this data model

    HotelSystem()
    {
        //Initialize Rooms
        for (int i = 0; i < 10; i++) 
        {
            luxuryRooms[i] = new LuxuryRoom(i + 200);		//LuxuryRooms are numbered 200-299
            economicRooms[i] = new EconomicRoom(i + 100);	//EconomicRooms are numbered 100-199
        }

        //Initialize Guests, Mangers and reservations lists
        managers = new ArrayList<Manager>();
        guests = new ArrayList<Guest>();
        reservations = new ArrayList<Reservation>();
        
        populateUsers();
    }

    //Populates user arraylists from the users.txt file
    public void populateUsers()
    {
    	try {
    		File f = new File("users.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String[] data = new String[6];
			while(line != null)
			{
				data = line.split(":");
				if(data[5].equalsIgnoreCase("guest")){
					guests.add(new Guest(data[0], data[1], data[2], data[3], data[4]));
				}else if(data[5].equalsIgnoreCase("manager")){
					managers.add(new Manager(data[0], data[1], data[2], data[3], data[4]));
				}line = br.readLine();
				
			}br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public ArrayList<Manager> getManagers()
    {
    	return managers;
    }
    
    public ArrayList<Guest> getGuests()
    {
    	return guests;
    }
    
    public ArrayList<Reservation> getReservations()
    {
    	return reservations;
    }
    
    //*********************** METHODS BASED ON USE CASES GO HERE *****************************
    
    public boolean checkGuest(String username, String password)
    {
    	for(Guest g : guests)
    	{
    		if(g.getUserName().equals(username) && g.getPassword().equals(password))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean checkManager(String username, String password)
    {
    	for(Manager m : managers)
    	{
    		if(m.getUserName().equals(username) && m.getPassword().equals(password))
    		{
    			return true;
    		}
    	}
    	return false;
    }
}