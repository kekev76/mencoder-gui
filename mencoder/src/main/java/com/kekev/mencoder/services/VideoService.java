package com.kekev.mencoder.services;

import java.util.ArrayList;
import java.util.List;

import com.kekev.mencoder.entity.Video;

public class VideoService {
	
	private static VideoService instance;
	
	private List<Video> videos;
	
	private VideoService(){
		
	}
	
	public static synchronized VideoService getInstance(){
		if(instance == null){
			instance = new VideoService();
		}
		return instance;
	}
	
	public synchronized List<Video> findLastVideo(){
		chargerListe();
		return videos;
	}
	
	private void chargerListe(){
		if(videos != null){
			return;
		}
		
		videos = new ArrayList<Video>();
		
		addVideo("test1", "subTest1");
		addVideo("test2", "subTest2");
		addVideo("test3", "subTest3");
		addVideo("test4", "subTest4");
		addVideo("test5", "subTest5");
	}
	
	private void addVideo(String title, String subTitle){
		videos.add(new Video(title, subTitle));		
	}

}
