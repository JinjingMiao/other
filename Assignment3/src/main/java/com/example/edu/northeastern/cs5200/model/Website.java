package com.example.edu.northeastern.cs5200.model;

import java.util.Collection;
import java.util.Date;

public class Website {
    Collection<Page> pages;
//    addPage(Page){};
//    removePage(Page){};
    private int id;
    private String name;
    private String description;
    private Date created;
    private Date updated;
    private int visits;

    public Website( String name, String description, Date created, Date updated, int visits, Collection<Page> pages) {
        super();
     
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.visits = visits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public int getVisits() {
        return visits;
    }

    public void setId(int id) {
       this.id = id;
   }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
