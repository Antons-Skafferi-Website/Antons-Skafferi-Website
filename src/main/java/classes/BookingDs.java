/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.BookingDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jonas
 */
public class BookingDs implements BookingDao {

    private String insertReservation = 
            "INSERT INTO APP.RESERVATION "
            + "(CUSTOMER_NAME, CUSTOMER_EMAIL, CUSTOMER_COUNT, RESERVATION_DATE, RESERVATION_TIME, TABLE_ID, PHONE_NUMBER, COMMENT) "
            + "VALUES(?, ?, ?, ?, ?, 1, ?, ?)";

    public boolean makeReservation(int numberOfGuests, String name, String email, String time, String phone, String comment) {

        try {
            
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(); //http request
            String temp = request.getParameter("date");

            if (temp.equals("")) //check is the date is set
                return false;

            if (comment.equals("")) //check if a comment is made, otherwise set it to null
                comment = null;
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(temp);
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());

            try (Connection connection = Database.getConnection();
                    PreparedStatement ps = connection.prepareCall(insertReservation);) {
                //setting the arguments for the prepared statement
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setInt(3, numberOfGuests);
                ps.setDate(4, sqlDate);
                ps.setString(5, time);
                ps.setString(6, phone);
                ps.setString(7, comment);

                ps.execute(); //execute the statement
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(BookingDs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
