/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jonas
 */
@Named(value = "dishBean")
@SessionScoped
public class Dish implements Serializable {

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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public long getDishId() {
        return dishId;
    }
}
