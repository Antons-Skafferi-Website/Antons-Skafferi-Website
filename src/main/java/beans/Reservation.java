/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.sql.Date;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author Felix
 */
@Named(value = "reservationBean")
@SessionScoped
public class Reservation implements Serializable{
    private final Database connection = new Database();
    
    private int numberOfGuests;
    private int tableID;
    private String name;
    private Date date;
    private String phone;
    private String time;
    private String email;
    private String comment;

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

    public void setDate(Date date) {
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

    public Date getDate() {
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
       if(connection.makeReservation(numberOfGuests, name, email, date, time, comment))
       {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage("Bokning genomförd!","The reservation was made successfully"));
       }
       else
       {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage("Något gick fel, försök igen","something went wrong during the reservation to the database"));
       }
        
    }

    
    
}
