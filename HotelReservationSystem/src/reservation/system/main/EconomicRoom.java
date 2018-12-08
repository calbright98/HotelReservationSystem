package reservation.system.main;
public class EconomicRoom extends Room {
    EconomicRoom(int n){
        super(n, 100.00, "Economic");
    }
    
    @Override
    public int compareTo(Room r) {
        return super.getRoomNumber() - r.getRoomNumber();
    }
}