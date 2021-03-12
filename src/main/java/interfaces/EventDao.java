/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import beans.EventController;
import java.util.List;
import model.Event;

/**
 *
 * @author jonas
 */
public interface EventDao {
    
    public List<Event> getEvents();

}
