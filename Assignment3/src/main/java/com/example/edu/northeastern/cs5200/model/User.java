package com.example.edu.northeastern.cs5200.model;

import java.util.Date;

public class User extends person{
    public int id;
    private Boolean userAgreement;
  

    public User ( int id,String firstName, String lastName, String username, String password, String email,Date dateOfBirth,Boolean userAgreement) {
        super (id,firstName,lastName,username,password,email, dateOfBirth);
    	

   
        this.id = id;
        this.userAgreement = userAgreement;
       
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserAgreement(Boolean userAgreement) {
        this.userAgreement = userAgreement;
    }

    public int getId() {
        return id;
    }

    public Boolean getUserAgreement() {
        return userAgreement;
    }
}