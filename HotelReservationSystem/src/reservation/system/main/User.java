package reservation.system.main;

import java.util.ArrayList;

public abstract class User 
{
   private String fName;
   private String lName;
   private String id;
   private String userName;
   private String pass;
   private String type;
   public ArrayList<Reservation> reservations;

   User(String f, String l, String userID, String uN, String p, String t){
       fName = f;
       lName = l;
       id = userID;
       userName = uN;
       pass = p;
       type = t;
       reservations = new ArrayList<Reservation>();
   }

   public String getFirstName(){return fName;}
   public String getLastName(){return lName;}
   public String getID(){return id;}
   public String getUserName(){return userName;}
   public String getPassword(){return pass;}
   public String getType(){return type;}
   public ArrayList<Reservation> getReservations(){return reservations;}
   public void addReservation(Reservation r){reservations.add(r);}
   
   public String toString() {
	   return fName + " " + lName + " " + id + " " + userName + " " + pass + " " + type;
   }
}