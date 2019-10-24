package com.example.edu.northeastern.cs5200.model;

public class HtmlWidget extends Widget {
	public int id;
    private String html;
    public HtmlWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String html) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		// TODO Auto-generated constructor stub
	}

	

    public int getId() {
        return id;
    }

    public String getHtml() {
        return html;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
