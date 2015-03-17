package com.kekev.mencoder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.kekev.mencoder.entity.Subtitle;
import com.kekev.mencoder.entity.Video;

public class VideoService {
	
	private static VideoService instance;
	
	private List<Video> videos;
	
	private VideoService(){
		videos = new ArrayList<Video>();
	}
	
	public static synchronized VideoService getInstance(){
		if(instance == null){
			instance = new VideoService();
		}
		return instance;
	}
	
	public synchronized List<Video> findLastVideo(){
		return videos;
	}
	
	public synchronized void addVideo(String title, String subTitle){
		addVideo(new Video(title, new Subtitle(subTitle)));
	}
	
	public synchronized void addVideo(Video video){
		videos.add(video);	
		sort();
	}
	
	private void sort(){
		Collections.sort(videos);
	}

}
