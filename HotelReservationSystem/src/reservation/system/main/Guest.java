package reservation.system.main;

public class Guest extends User {
    public Guest(String f, String l, String id, String uN, String p){
        super(f, l, id, uN, p, "guest");
    }
}