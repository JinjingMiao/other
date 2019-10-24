package com.example.edu.northeastern.cs5200.model;

import java.util.Collection;
import java.util.Date;

public class Page {
    Website website;
    public int id;
    private String title;

    public Page(  int id, String title, String description, Date created, Date updated, int views, Collection<Widget> widgets) {
    	super();
    	this.id= id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.views = views;
        
    }

    private String description;
    private Date created;
    private Date updated;
    private int views;
    private Collection<Widget> widgets;
     
    public int getId(){
    	return id;
    }
  

    public String getTitle() {
        return title;
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

    public int getViews() {
        return views;
    }

   
    public void setID(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
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

    public void setViews(int views) {
        this.views = views;
    }
}

