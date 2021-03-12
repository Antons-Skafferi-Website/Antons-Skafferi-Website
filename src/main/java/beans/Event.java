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

/**
 *
 * @author rickard1
 */
@Named(value = "eventBean")
@Dependent
public class Event implements Serializable {

    private String eventName;
    private String eventDesc;
    private String eventDate;
    private String eventTime;
    private String eventURL;

    private final EventDs ds = new EventDs();

    public Event() {
    }

    public Event(String name, String desc, String date, String time, String URL) {
        this.eventName = name;
        this.eventDesc = desc;
        this.eventDate = date;
        this.eventTime = time;
        this.eventURL = URL;
    }

    public String getName() {
        return eventName;
    }

    public String getDescription() {
        return eventDesc;
    }

    public String getDate() {
        return eventDate;
    }

    public String getTime() {
        return eventTime;
    }

    public String getURL() {
        return eventURL;
    }

    public List<Event> getCurrentEvent() {
        return ds.getEvents();
    }

}
