package com.example.edu.northeastern.cs5200.model;

public enum Role {
	OWNER,
    ADMIN,
    WRITER,
    EDITOR,
    REVIEWER;
    
    public int getIndex() {
     return ordinal() + 1; 
    }
}

