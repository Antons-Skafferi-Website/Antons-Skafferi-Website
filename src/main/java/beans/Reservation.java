/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Database;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
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
    private String name;
    private String date;
    private String phone;
    private String time;
    private String email;

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
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

    public String getDate() {
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
    
    public String makeReservation() {
       if(connection.makeReservation(numberOfGuests, name, email))
       {
           return "Bokning genomförd!";
       }
       else
       {
           return "Något gick fel, försök igen.";
       }
        
    }

    
    
}
