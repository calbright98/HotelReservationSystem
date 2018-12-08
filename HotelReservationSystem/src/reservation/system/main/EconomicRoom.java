package reservation.system.main;
public class EconomicRoom extends Room {
    EconomicRoom(int n){
        super(n, 100.00, "Economic");
    }
    
    @Override
    public int compareTo(Object o) {
        Room er = (Room) o;
        return super.getRoomNumber() - er.getRoomNumber();
    }
}