
package domain;

/**
 *
 * @author jonas
 */
public class Dish {

    private long dishId;
    private String name;
    private String description;
    private double price;

    public Dish() {
    }

    public Dish(long dishId, String name, String description, double price) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public long getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
