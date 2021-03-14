/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author jonas
 */
public class Event {

    private String name;
    private String description;
    private String imageUrl;
    private LocalDate date;

    public Event() {
    }

    public Event(String name, LocalDate date, String description, String imageUrl) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        imageUrl = imageUrl;
    }
    
}
