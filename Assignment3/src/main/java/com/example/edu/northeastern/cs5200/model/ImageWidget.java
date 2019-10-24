package com.example.edu.northeastern.cs5200.model;

public class ImageWidget extends Widget {
	public int id;
    private String src;
    public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order,String src) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		// TODO Auto-generated constructor stub
	}

	

    public int getId() {
        return id;
    }

    public String getSrc() {
        return src;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
