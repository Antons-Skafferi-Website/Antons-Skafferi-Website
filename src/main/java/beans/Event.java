/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
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
    private Database connection;
    private String eventName;
    private String eventDesc;
    private String eventDate;
    private String eventTime;
    /**
     * Creates a new instance of Event
     */
    public Event() {
        connection = new Database();
    }
    
    public Event(String name, String desc, String date, String time) {
        this.eventName = name;
        this.eventDesc = desc;
        this.eventDate = date;
        this.eventTime = time;
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
    
    public List<Event> getCurrentEvent(){
        return connection.getEvents();
    }
    
}
