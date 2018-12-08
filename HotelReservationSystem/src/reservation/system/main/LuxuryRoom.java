package reservation.system.main;
public class LuxuryRoom extends Room {
    LuxuryRoom(int n){
        super(n, 300.00, "Luxury");
    }
    
    @Override
    public int compareTo(Object o) {
        Room lr = (Room) o;
        return super.getRoomNumber() - lr.getRoomNumber();
    }
}