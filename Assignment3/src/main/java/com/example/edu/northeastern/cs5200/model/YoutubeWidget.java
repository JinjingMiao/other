package com.example.edu.northeastern.cs5200.model;



public class YoutubeWidget extends Widget{
	public int id;
    private String url;
    private Boolean shareble;
    private Boolean expandable;
    public YoutubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String url, Boolean sharable, Boolean expandable) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		// TODO Auto-generated constructor stub
	}

	

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getShareble() {
        return shareble;
    }

    public Boolean getExpandable() {
        return expandable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setShareble(Boolean shareble) {
        this.shareble = shareble;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }
}

