package com.kekev.mencoder.entity;

public class Subtitle {
	
	private String title;
	private static String path;
	
	
	public Subtitle(String title) {
		super();
		this.title = title;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public static String getPath() {
		return path;
	}


	public static  void setPath(String path) {
		Subtitle.path = path;
	}
	
	
}
