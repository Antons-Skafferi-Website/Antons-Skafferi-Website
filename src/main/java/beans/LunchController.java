/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.DishDs;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import domain.Dish;

/**
 * Controller class for lunch.
 * @author jonas
 */
@Named(value = "lunchBean")
@Dependent
public class LunchController implements Serializable {

    private final DishDs ds = new DishDs();

    public LunchController() {
    }

    public List<Dish> getMondayLunch() {
        return ds.getSubMenu(1);
    }

    public List<Dish> getTuesdayLunch() {
        return ds.getSubMenu(2);
    }

    public List<Dish> getWednesdayLunch() {
        return ds.getSubMenu(3);
    }

    public List<Dish> getThursdayLunch() {
        return ds.getSubMenu(4);
    }

    public List<Dish> getFridayLunch() {
        return ds.getSubMenu(5);
    }

    public List<Dish> getTodaysLunch() {

        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.MONDAY:
                return getMondayLunch();
            case Calendar.TUESDAY:
                return getTuesdayLunch();
            case Calendar.WEDNESDAY:
                return getWednesdayLunch();
            case Calendar.THURSDAY:
                return getThursdayLunch();
            case Calendar.FRIDAY:
                return getFridayLunch();
        }

        return Collections.emptyList();
    }
    
    public String getTodaysWeekday() {

        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.MONDAY:
                return "Måndag";
            case Calendar.TUESDAY:
                return "Tisdag";
            case Calendar.WEDNESDAY:
                return "Onsdag";
            case Calendar.THURSDAY:
                return "Torsdag";
            case Calendar.FRIDAY:
                return "Fredag";
        }

        return "Kommer på måndag";
    }
}
