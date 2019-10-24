package com.example.edu.northeastern.cs5200.model;

public class Phone  {
    public int id;
    private String phone;
    private Boolean primary;
    
    

    public Phone(int id, String phone, Boolean primary) {
		super();
		this.id = id;
		this.phone = phone;
		this.primary = primary;
	}

	public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }
}