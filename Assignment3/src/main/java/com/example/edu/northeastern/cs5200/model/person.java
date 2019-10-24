package com.example.edu.northeastern.cs5200.model;

import java.util.Collection;
import java.util.Date;

public class person {
    public int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private Date dateOfBirth;
    private Collection <Phone> phone;
    private Collection <Address> address;
   
    
    public person(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public person(int id, String firstName, String lastName, String userName, String password, String email,
			Date dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
    
    

	


	public person(int id, String firstName, String lastName, String userName, String password, String email,
			Date dateOfBirth, Collection <Phone> phone, Collection <Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
	}



	public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }



	public Collection<Phone> getPhone() {
		return phone;
	}



	public void setPhone(Collection<Phone> phone) {
		this.phone = phone;
	}



	public Collection<Address> getAddress() {
		return address;
	}



	public void setAddress(Collection<Address> address) {
		this.address = address;
	}

   
}
