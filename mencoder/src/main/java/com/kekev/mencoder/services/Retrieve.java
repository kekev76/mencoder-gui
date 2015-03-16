package com.kekev.mencoder.services;

import java.io.File;

import com.kekev.mencoder.entity.Subtitle;
import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.view.Fenetre;

public class Retrieve {

	public static void RetrieveVideo(){
		
		File repertoire = new File(Video.getPathToVideo());
		String[] fichiers = repertoire.list();
		
		VideoService service = VideoService.getInstance();
		
		for(String fichier : fichiers){
			System.out.println(fichier);
			if(isVideo(fichier))
				service.addVideo(new Video(fichier));
		}
		Fenetre.update();
	}
	
	private static boolean isVideo(String fichier){
		return fichier.endsWith(".mp4") || fichier.endsWith(".avi") || fichier.endsWith(".mkv");
	}
	
	public static void RetrieveSub(){
		
		File repertoire = new File(Subtitle.getPath());
		String[] fichiers = repertoire.list();
		
		VideoService service = VideoService.getInstance();
		//TODO retrieve all video
		
		
		for(String fichier : fichiers){
			System.out.println(fichier);
			if(fichier.endsWith(".str")){
				//TODO match video with sub
				//service.addVideo(new Video(fichier));
			}
		}
		Fenetre.update();
	}
}
