/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.BookingDs;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Felix
 */
@Named(value = "bookingBean")
@SessionScoped
public class BookingController implements Serializable {

    private final BookingDs ds = new BookingDs();

    private int numberOfGuests;
    private int tableID;
    private String name;
    private LocalDate date;
    private String phone;
    private String time;
    private String email;
    private String comment;
    private LocalDate min;
    private LocalDate max;

    public BookingController() {
        LocalDate todaysDate = LocalDate.now(); // get todays date
        date = todaysDate;
        LocalDate temp = date;
        max = temp.plusDays(30); //max reservation date 30 days ahead
        min = date; //min reservation date as of todays date
    }
    
    public void setMax(LocalDate max) {
        this.max = max;
    }

    public LocalDate getMax() {
        return max;
    }

    public void setMin(LocalDate min) {
        this.min = min;
    }

    public LocalDate getMin() {
        return min;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getTableID() {
        return tableID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String getTime() {
        return time;
    }

    public String getEmail() {
        return email;
    }

    public void makeReservation() throws ParseException {
        if (ds.makeReservation(numberOfGuests, name, email, time, phone, comment)) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage("Bokning genomförd!", "The reservation was made successfully"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage("Något gick fel, försök igen", "something went wrong during the reservation to the database"));
        }

    }

}
