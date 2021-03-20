
package beans;

import classes.EventDs;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import domain.Event;

/**
 * Controller class for events.
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
