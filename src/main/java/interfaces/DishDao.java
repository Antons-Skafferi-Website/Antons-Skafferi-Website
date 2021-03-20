
package interfaces;

import java.util.List;
import domain.Dish;

/**
 *
 * @author jonas
 */
public interface DishDao {

    public List<Dish> getSubMenu(long menuId);

}
