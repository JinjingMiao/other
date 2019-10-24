package com.example.edu.northeastern.cs5200.model;

public class Address {
    public int id;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private Boolean primary;
    public Address(int id, String street1, String street2, String city, String state, String zip, Boolean primary) {
		super();
		this.id = id;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.primary = primary;
	}

    public int getId() {
        return id;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }



	public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }
}
