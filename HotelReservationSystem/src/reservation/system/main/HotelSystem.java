package reservation.system.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import reservation.panels.MessageWindow;

public class HotelSystem {
	
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private LuxuryRoom[] luxuryRooms = new LuxuryRoom[10];
    private EconomicRoom[] economicRooms = new EconomicRoom[10];
    private ArrayList<Manager> managers;
    private ArrayList<Guest> guests;
    private ArrayList<Reservation> reservations;
    //either an action listener or changeListner needed to attach the main display frame to this data model

    HotelSystem()
    {
        //Initialize Rooms
        for (int i = 0; i < 10; i++) 
        {
            rooms.add(luxuryRooms[i] = new LuxuryRoom(i + 200));		//LuxuryRooms are numbered 200-299
            rooms.add(economicRooms[i] = new EconomicRoom(i + 100));	//EconomicRooms are numbered 100-199
        }

        //Initialize Guests, Mangers and reservations lists
        managers = new ArrayList<Manager>();
        guests = new ArrayList<Guest>();
        reservations = new ArrayList<Reservation>();
        
        populateUsers();
        
        for(Guest g : guests)
        {
        	System.out.println(g.toString());
        }
                        
        for(Reservation r : reservations)
        {
        	System.out.println(r.toString());
        }
    }

    public ArrayList<Room> getRooms()
    {
    	return rooms;
    }
    
    //Populates user arraylists from the users.txt file
    public void populateUsers()
    {
    	try {
    		File f = new File("users.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			while(line != null)
			{
				String[] data = line.split(":");
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
    
    //Populates reservations arraylist from the reservations.txt file
    public void populateReservations()
    {
        int count = 0;
        try {
            File f = new File("reservations.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while(line != null)
            {
                String[] data = line.split(":");
                Guest g = getGuest(data[0]);		//Finds the guest who made reservation
                if(g == null)						//If the guest in the reservation is not in the system, the loop will skip that reservation and print out error message
                {
                    line = br.readLine();
                    continue;
                }
                Room r = getRoom(Integer.parseInt(data[1]));	//Finds room that was reserved

                LocalDate s = LocalDate.parse(data[2], DateTimeFormatter.ofPattern("u-M-d"));
                LocalDate e = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("u-M-d"));

                Reservation newRes = new Reservation(g, r, s, e);
                if(reservations.contains(newRes))
                {
                    line = br.readLine();
                	continue;
                }
                
                LocalDate created = LocalDate.parse(data[4], DateTimeFormatter.ofPattern("u-M-d"));
                newRes.setCreatedDate(created);                
                reservations.add(newRes);

                //Add Set Reserved Days for the room
                LocalDate cur = LocalDate.parse(data[2], DateTimeFormatter.ofPattern("u-M-d"));
                ArrayList<LocalDate> reservedDays = new ArrayList<>();
                while(cur.isBefore(e) || cur.isEqual(e)) {
                    reservedDays.add(cur);
                    cur = cur.plusDays(1);
                }
                r.addReservedDate(reservedDays);

                count++;
                line = br.readLine();
            }br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MessageWindow mw = new MessageWindow(count + ": reservations loaded");
    }
    
    public void saveReservations(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("reservations.txt", false));
            for(Reservation r : reservations){
                bw.newLine();
                bw.append(r.getGuest().getID() + ":" + r.getRoom().getRoomNumber() + ":" + r.getStartDate() + ":" + r.getEndDate() + ":" + r.getCreatedDate());
            }
            bw.close();
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
    
    /**
     * Gets the guest with the specified first name
     * @param ID the ID of the guest with this reservation
     * @return the guest whose first name matches with the given name
     */
    public Guest getGuest(String ID) {
        for(Guest g : guests){
            if(g.getID().equalsIgnoreCase(ID))
                return g;
        }return null;
    }
    
    /**
     * Gets the appropriate room with the parsed roomNumber
     * @param roomNumber the number of the room to be found
     * @return
     */
    public Room getRoom(int roomNumber)
    {
    	for(Room r : rooms)
    	{
    		if(r.getRoomNumber() == roomNumber)
    			return r;
    	}
    	
    	return null;
    }
    
    public User getUser(String username)
    {
    	for(Guest g : guests)
    	{
    		if(g.getUserName().equals(username))
    		{
    			return g;
    		}
    	}
    	
    	for(Manager m : managers)
    	{
    		if(m.getUserName().equals(username))
    		{
    			return m;
    		}
    	}
    	return null;
    }
    
    /**
     * 
     * @param luxury True if the room is luxury, false if it is economic
     * @param ci The requested check-in date
     * @param co The requested check-out date
     * @return an available luxury or economic room or null if none are available
     */
    public Room getAvailableRoom(boolean luxury, LocalDate ci, LocalDate co)
    {
    	if(luxury) {
    		for(Room r : luxuryRooms) {
    			if(r.checkAvailability(ci, co)) {
    				return r;
    			}
    		}
    	}else {
    		for(Room r : economicRooms) {
    			if(r.checkAvailability(ci, co)) {
    				return r;
    			}
    		}
    	}return null;
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
    
    public boolean checkGuest(String username)
    {
    	for(Guest g : guests)
    	{
    		if(g.getUserName().equals(username))
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

	public void addGuest(Guest g) 
	{
		guests.add(g);
        try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true));
			bw.newLine();
			bw.append(g.getFirstName() + ":" + g.getLastName() + ":" +  g.getID() + ":" +  g.getUserName() + ":" +  g.getPassword() + ":" + g.getType());
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public void addReservation(Reservation r)
    {
        reservations.add(r);
        LocalDate cur = r.getStartDate();
        LocalDate end = r.getEndDate();
        ArrayList<LocalDate> reservedDays = new ArrayList<>();
        while(cur.isBefore(end) || cur.isEqual(end)) {
            reservedDays.add(cur);
            cur = cur.plusDays(1);
        }
        Room room = r.getRoom();
        room.addReservedDate(reservedDays);
    }
}