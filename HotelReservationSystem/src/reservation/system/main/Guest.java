package reservation.system.main;

public class Guest extends User {
    Guest(String f, String l, String id, String uN, String p){
        super(f, l, id, uN, p, "Guest");
    }
}