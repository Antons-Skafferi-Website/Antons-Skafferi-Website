/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.EventDs;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Event;

/**
 *
 * @author rickard1
 */
@Named(value = "eventBean")
@Dependent
public class EventController implements Serializable {

    private final EventDs ds = new EventDs();

    public EventController() {
    }
    
    public Event getCommingEvent() {
        return ds.getEvent();
    }

}
