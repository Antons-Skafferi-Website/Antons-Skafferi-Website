/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import beans.Event;
import interfaces.EventDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class EventDs implements EventDao {

    private String getEvent = "SELECT EVENT_NAME, EVENT_DESC, EVENT_DATE, EVENT_TIME, IMAGE_URL FROM APP.EVENTS WHERE EVENT_ID = 1";  //eftersom det bara är ett event i databasen så väljer vi alltid samma

    public List<Event> getEvents() {
        List<Event> list = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareCall(getEvent);) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Event(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
