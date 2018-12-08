package reservation.system.main;
public class LuxuryRoom extends Room {
    LuxuryRoom(int n){
        super(n, 300.00, "Luxury");
    }
    
    @Override
    public int compareTo(Room r) {
        return super.getRoomNumber() - r.getRoomNumber();
    }
}