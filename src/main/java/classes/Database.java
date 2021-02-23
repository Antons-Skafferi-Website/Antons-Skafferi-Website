/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import beans.Dish;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
}
