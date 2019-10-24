package com.example.edu.northeastern.cs5200.model;

public class HeadingWidget extends Widget {
	public int id;
    private int size;
    public HeadingWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, int size) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.id= id;
		this.size = size;
		
		// TODO Auto-generated constructor stub
	}

	

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }
}