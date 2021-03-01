/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatess
 * and open the template in the editor.
 */
package classes;


import beans.Dish;
import java.sql.Connection;
import java.sql.Date;
//import java.time.LocalDate;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jonas
 */
public class Database {
    
    private String dbURL;
    private String user;
    private String pw;
    
    private String getSubmenuDishes = 
    "SELECT D.DISH_ID, D.DISH_NAME, D.DESCRIPTION, D.PRICE FROM APP.DISH AS D " +
    "INNER JOIN APP.SUB_MENU_HAS_DISH AS SMHD ON D.DISH_ID = SMHD.DISH_ID " +
    "WHERE SMHD.SUB_MENU_ID = ?";
    
    private String insertReservation = "INSERT INTO APP.RESERVATION " + 
    "(CUSTOMER_NAME, CUSTOMER_EMAIL, CUSTOMER_COUNT, RESERVATION_DATE, RESERVATION_TIME, TABLE_ID, COMMENT)\n" +
    "VALUES(?, ?, ?, ?, ?, 1, ?)";
    
    //int numberOfGuests, String name, String date,  String email
    public Database() {
        this.dbURL = "jdbc:derby://localhost:1527/AntonsSkafferi";
        this.user = "anton";
        this.pw = "anton";
    }
    
    public List<Dish> getSubMenu(long menuId) {
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
             PreparedStatement statement = connection.prepareCall(getSubmenuDishes);
        ){
            
            statement.setLong(1, menuId);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) 
                list.add(new Dish(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public boolean makeReservation(int numberOfGuests, String name, String email, String time, String comment) throws ParseException {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest(); //http request
        String temp = request.getParameter("date");
        if(temp.equals("")) //check is the date is set
            return false;
        if(comment.equals("")) //check if a comment is made, otherwise set it to null
            comment = null;
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse(temp);
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
        try (Connection connection = DriverManager.getConnection(dbURL, user, pw);
            PreparedStatement ps = connection.prepareCall(insertReservation);
        ){
            //setting the arguments for the prepared statement
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, numberOfGuests);
            ps.setDate(4, sqlDate);
            ps.setString(5, time);
            ps.setString(6, comment);
            
            ps.execute(); //execute the statement
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }  
    }
    
}
