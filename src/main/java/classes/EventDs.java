
package classes;

import interfaces.EventDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import domain.Event;

/**
 * Data source class for events.
 * @author jonas
 */
public class EventDs implements EventDao {

    private String getEvent = "SELECT EVENT_NAME, DESCRIPTION, IMG_URL, EVENT_DATE FROM APP.EVENT ";

    /**
     * Get upcoming event.
     * @return Event
     */
    @Override
    public Event getEvent() {

        try ( Connection connection = Database.getConnection();  
              PreparedStatement statement = connection.prepareCall(getEvent);) {

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Event(rs.getString(1), rs.getDate(4).toLocalDate(), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Event("Error", LocalDate.now(), "Error", "Error");
    }

}
