package com.kekev.mencoder.entity;

public class Subtitle implements Comparable<Subtitle>{
	
	private String title;
	private Episode episode;
	private static String path;
	
	
	public Subtitle(String title) {
		super();
		this.title = title;
	}
	
	public Subtitle(String title, Episode episode) {
		super();
		this.title = title;
		this.episode = episode;
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

	public Episode getEpisode() {
		return episode;
	}

	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

	@Override
	public int compareTo(Subtitle o) {
		return title.compareTo(o.getTitle());
	}
	
	
}
