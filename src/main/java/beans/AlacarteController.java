/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.DishDs;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Dish;

/**
 *
 * @author jonas
 */
@Named(value = "alacarteBean")
@SessionScoped
public class AlacarteController implements Serializable {

    private final DishDs ds = new DishDs();

    public AlacarteController() {
    }

    public List<Dish> getStarters() {
        return ds.getSubMenu(6);
    }

    public List<Dish> getMainDishes() {
        return ds.getSubMenu(7);
    }

    public List<Dish> getDesserts() {
        return ds.getSubMenu(8);
    }
}
