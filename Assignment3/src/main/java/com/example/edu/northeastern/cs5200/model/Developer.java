package com.example.edu.northeastern.cs5200.model;

import java.util.Collection;
import java.util.Date;

public class Developer extends person {

    public int id;
    private String developerKey;
    
    
    public Developer ( int id,String firstName, String lastName, String username, String password, String email,Date dateOfBirth, Collection<Phone> phone,  Collection <Address> address,String developerKey) {
    	super (id,firstName,lastName,username,password,email, dateOfBirth,phone,address);
    	this.id = id;
        this.developerKey = developerKey;
    }
    
    public Developer ( int id, String firstName, String lastName) {
    	super (id, firstName, lastName);
    	this.id = id;
        this.developerKey = developerKey;
    }
    
    public Developer ( int id,String firstName, String lastName, String username, String password, String email,Date dateOfBirth) {
        super (id,firstName,lastName,username,password,email, dateOfBirth);
    	this.id = id;
        this.developerKey = developerKey;

    }
    
   
    
    
	
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

}


// 3 public developer ? if there are three developer, there will be some problems, length is different the inhertence will  have some problems.