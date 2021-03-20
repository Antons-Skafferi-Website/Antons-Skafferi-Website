
package interfaces;

/**
 *
 * @author jonas
 */
public interface BookingDao {

    public boolean makeReservation(int numberOfGuests, String name, String email, String time, String phone, String comment);
    
}
