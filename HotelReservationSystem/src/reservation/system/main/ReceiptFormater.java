package reservation.system.main;

/**
 * a interface for receipt formater
 * @author Chong, Chanip @version 1.0 12/8/2018
 */
public interface ReceiptFormater
{
  /**
   * to make a reservation into a String
   * @param R one reservation in the system
   * @return one string that holds name, room, price, period
   */
  String information(Reservation R);
  /**
   * to return price for one reservation and as a String
   * @return a total amount for one reservation
   */
  String totalmoney();
}