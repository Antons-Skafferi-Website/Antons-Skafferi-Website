package classes;

import interfaces.DishDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Dish;

/**
 * Data source class for dish.
 * @author jonas
 */
public class DishDs implements DishDao {
    
    private String getSubmenuDishes = 
    "SELECT D.DISH_ID, D.DISH_NAME, D.DESCRIPTION, D.PRICE FROM APP.DISH AS D " +
    "INNER JOIN APP.SUB_MENU_HAS_DISH AS SMHD ON D.DISH_ID = SMHD.DISH_ID " +
    "WHERE SMHD.SUB_MENU_ID = ?";
    
    /**
     * Get all dishes that belongs to a certain sub menu.
     * @param menuId Id
     * @return All dishes from sub menu
     */
    public List<Dish> getSubMenu(long menuId) {
        
        List<Dish> list = new ArrayList<>();
        
        try (Connection connection = Database.getConnection();
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
