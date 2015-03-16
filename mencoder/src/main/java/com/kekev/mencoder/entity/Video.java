package com.kekev.mencoder.entity;

public class Video {
	
	private String title;
	private Subtitle sub;
	private static String pathToVideo;
	private boolean ending = false;

	public Video(String title) {
		super();
		this.title = title;
	}
	
	public Video(String title, Subtitle sub) {
		super();
		this.title = title;
		this.sub = sub;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static String getPathToVideo() {
		return pathToVideo;
	}

	public static void setPathToVideo(String pathToVideo) {
		Video.pathToVideo = pathToVideo;
	}
	
	public boolean isEnding() {
		return ending;
	}

	public void setEnding(boolean ending) {
		this.ending = ending;
	}

	public Subtitle getSub() {
		return sub;
	}

	public void setSub(Subtitle sub) {
		this.sub = sub;
	}
}
