package com.kekev.mencoder.entity;

public class Video {
	
	private String title;
	private String subTitle;
	private String pathToVideo;
	private String pathToSub;
	private boolean ending = false;

	public Video(String title, String subTitle) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.pathToVideo = pathToVideo;
		this.pathToSub = pathToSub;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getPathToVideo() {
		return pathToVideo;
	}

	public void setPathToVideo(String pathToVideo) {
		this.pathToVideo = pathToVideo;
	}

	public String getPathToSub() {
		return pathToSub;
	}

	public void setPathToSub(String pathToSub) {
		this.pathToSub = pathToSub;
	}

	
	public boolean isEnding() {
		return ending;
	}

	public void setEnding(boolean ending) {
		this.ending = ending;
	}

}
